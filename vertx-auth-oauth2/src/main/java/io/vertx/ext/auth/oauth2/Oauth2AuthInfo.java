package io.vertx.ext.auth.oauth2;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject
public class Oauth2AuthInfo extends JsonObject {

  public Oauth2AuthInfo() {
  }

  public Oauth2AuthInfo(Oauth2AuthInfo other) {
    mergeIn(other, true);
  }

  public Oauth2AuthInfo(JsonObject json) {
    mergeIn(json, true);
  }

  public Oauth2AuthInfo setAccessToken(String value) {
    put("access_token", value);
    return this;
  }

  public Oauth2AuthInfo setCode(String value) {
    put("code", value);
    return this;
  }

  public Oauth2AuthInfo setRedirectUri(String value) {
    put("redirect_uri", value);
    return this;
  }

  public Oauth2AuthInfo setUsername(String value) {
    put("username", value);
    return this;
  }

  public Oauth2AuthInfo setPassword(String value) {
    put("password", value);
    return this;
  }

  public JsonObject toJson() {
    return this;
  }
}
