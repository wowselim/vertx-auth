/*
 * Copyright 2014 Red Hat, Inc.
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
package io.vertx.ext.auth.authentication;

/**
 * Exception used to signal that the given AuthInfo object is invalid
 */
public final class InvalidAuthInfoException extends RuntimeException {

  /**
   * Creates a new exception signaling that the authInfo object is invalid
   * with a given error message.
   *
   * @param message the error message
   */
  public InvalidAuthInfoException(String message) {
    super(message);
  }

  /**
   * Creates a new exception signaling that the authInfo object is invalid
   * with a given error message.
   *
   * @param message the error message
   * @param cause the cause of the error
   */
  public InvalidAuthInfoException(String message, Throwable cause) {
    super(message, cause);
  }
}
