package io.vertx.ext.auth.impl;

import io.vertx.core.json.JsonObject;
import io.vertx.ext.auth.authentication.InvalidAuthInfoException;

public final class AuthInfoUtil {

  public static String getNonEmpty(JsonObject authInfo, String key) throws InvalidAuthInfoException {
    // null check
    if (authInfo == null) {
      throw new InvalidAuthInfoException("authInfo is null");
    }
    final String value;
    // type check
    try {
      value = authInfo.getString(key);
    } catch (RuntimeException e) {
      throw new InvalidAuthInfoException("wrong type for [" + key + "]", e);
    }
    if (value == null || value.length() == 0) {
      throw new InvalidAuthInfoException("authInfo[" + key + "] cannot be null or empty");
    }

    return value;
  }

  public static String getNonNull(JsonObject authInfo, String key) throws InvalidAuthInfoException {
    // null check
    if (authInfo == null) {
      throw new InvalidAuthInfoException("authInfo is null");
    }
    final String value;
    // type check
    try {
      value = authInfo.getString(key);
    } catch (RuntimeException e) {
      throw new InvalidAuthInfoException("wrong type for [" + key + "]", e);
    }
    if (value == null) {
      throw new InvalidAuthInfoException("authInfo[" + key + "] cannot be null");
    }

    return value;
  }

  public static String get(JsonObject authInfo, String key) throws InvalidAuthInfoException {
    // null check
    if (authInfo == null) {
      throw new InvalidAuthInfoException("authInfo is null");
    }
    // type check
    try {
      return authInfo.getString(key);
    } catch (RuntimeException e) {
      throw new InvalidAuthInfoException("wrong type for [" + key + "]", e);
    }
  }

  public static JsonObject getNonNullObject(JsonObject authInfo, String key) throws InvalidAuthInfoException {
    // null check
    if (authInfo == null) {
      throw new InvalidAuthInfoException("authInfo is null");
    }
    final JsonObject value;
    // type check
    try {
      value = authInfo.getJsonObject(key);
    } catch (RuntimeException e) {
      throw new InvalidAuthInfoException("wrong type for [" + key + "]", e);
    }
    if (value == null) {
      throw new InvalidAuthInfoException("authInfo[" + key + "] cannot be null");
    }

    return value;
  }

}
