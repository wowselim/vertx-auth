package io.vertx.ext.auth.jwt;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject
public class JWTAuthInfo extends JsonObject {

  public JWTAuthInfo() {
  }

  public JWTAuthInfo(JWTAuthInfo other) {
    mergeIn(other, true);
  }

  public JWTAuthInfo(JsonObject json) {
    mergeIn(json, true);
  }

  public JWTAuthInfo setJWT(String value) {
    put("jwt", value);
    return this;
  }

  public JsonObject toJson() {
    return this;
  }
}
