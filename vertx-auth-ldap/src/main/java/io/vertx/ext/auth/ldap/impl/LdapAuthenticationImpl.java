/********************************************************************************
 * Copyright (c) 2019 Stephane Bastian
 *
 * This program and the accompanying materials are made available under the 2
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0 3
 *
 * Contributors: 4
 *   Stephane Bastian - initial API and implementation
 ********************************************************************************/
package io.vertx.ext.auth.ldap.impl;

import java.util.Hashtable;
import java.util.Objects;

import javax.naming.Context;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;

import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.auth.User;
import io.vertx.ext.auth.authentication.InvalidAuthInfoException;
import io.vertx.ext.auth.ldap.LdapAuthentication;
import io.vertx.ext.auth.ldap.LdapAuthenticationOptions;

import static io.vertx.ext.auth.impl.AuthInfoUtil.getNonEmpty;
import static io.vertx.ext.auth.impl.AuthInfoUtil.getNonNull;

/**
 *
 * @author <a href="mail://stephane.bastian.dev@gmail.com">Stephane Bastian</a>
 */
public class LdapAuthenticationImpl implements LdapAuthentication {
  private static final String SIMPLE_AUTHENTICATION_MECHANISM = "simple";
  private static final String FOLLOW_REFERRAL = "follow";

  private Vertx vertx;
  private LdapAuthenticationOptions authenticationOptions;

  public LdapAuthenticationImpl(Vertx vertx, LdapAuthenticationOptions authenticationOptions) {
    this.vertx = Objects.requireNonNull(vertx);
    this.authenticationOptions = Objects.requireNonNull(authenticationOptions);
  }

  @Override
  public void authenticate(JsonObject authInfo, Handler<AsyncResult<User>> resultHandler) {
    try {
      String principal = getNonEmpty(authInfo, "username");
      String credential = getNonNull(authInfo, "password");

      String ldapPrincipal = getLdapPrincipal(principal);
      createLdapContext(ldapPrincipal, credential, contextResponse -> {
        if (contextResponse.succeeded()) {
          User user = User.create(new JsonObject().put("username", principal));
          resultHandler.handle(Future.succeededFuture(user));
        } else {
          resultHandler.handle(Future.failedFuture(contextResponse.cause()));
        }
      });
    } catch (InvalidAuthInfoException e) {
      resultHandler.handle(Future.failedFuture(e));
    }
  }

  private void createLdapContext(String principal, String credential, Handler<AsyncResult<LdapContext>> resultHandler) {
    Hashtable<String, Object> environment = new Hashtable<>();
    // set the initial cntext factory
    environment.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
    // set the url
    environment.put(Context.PROVIDER_URL, authenticationOptions.getUrl());

    if (principal != null) {
      environment.put(Context.SECURITY_PRINCIPAL, principal);
    }
    if (credential != null) {
      environment.put(Context.SECURITY_CREDENTIALS, credential);
    }
    if (authenticationOptions.getAuthenticationMechanism() == null && (principal != null || credential != null)) {
      environment.put(Context.SECURITY_AUTHENTICATION, SIMPLE_AUTHENTICATION_MECHANISM);
    }
    // referral
    environment.put(Context.REFERRAL,
        authenticationOptions.getReferral() == null ? FOLLOW_REFERRAL : authenticationOptions.getReferral());
    vertx.executeBlocking(blockingResult -> {
      try {
        LdapContext context = new InitialLdapContext(environment, null);
        blockingResult.complete(context);
      } catch (Throwable t) {
        blockingResult.fail(t);
      }
    }, resultHandler);
  }

  private String getLdapPrincipal(String principal) {
    return authenticationOptions.getAuthenticationQuery().replace("{0}", principal);
  }

}
