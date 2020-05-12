/*
 * Copyright 2019 Red Hat, Inc.
 *
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  and Apache License v2.0 which accompanies this distribution.
 *
 *  The Eclipse Public License is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  The Apache License v2.0 is available at
 *  http://www.opensource.org/licenses/apache2.0.php
 *
 *  You may elect to redistribute this code under either of these licenses.
 */

package io.vertx.ext.auth.webauthn;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject
public class WebAuthnAuthInfo extends JsonObject {

  public WebAuthnAuthInfo() {}

  public WebAuthnAuthInfo(WebAuthnAuthInfo other) {
    mergeIn(other, true);
  }

  public WebAuthnAuthInfo(JsonObject json) {
    mergeIn(json, true);
  }

  public WebAuthnAuthInfo setChallenge(String value) {
    put("challenge", value);
    return this;
  }

  public WebAuthnAuthInfo setWebauthn(JsonObject value) {
    put("webauthn", value);
    return this;
  }

  public WebAuthnAuthInfo setUsername(String value) {
    put("username", value);
    return this;
  }

  public JsonObject toJson() {
    return this;
  }
}
