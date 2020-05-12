package io.vertx.ext.auth.properties;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject
public class PropertiesAuthInfo extends JsonObject {

  public PropertiesAuthInfo() {
  }

  public PropertiesAuthInfo(PropertiesAuthInfo other) {
    mergeIn(other, true);
  }

  public PropertiesAuthInfo(JsonObject json) {
    mergeIn(json, true);
  }

  public PropertiesAuthInfo setUsername(String username) {
    put("username", username);
    return this;
  }

  public PropertiesAuthInfo setPassword(String password) {
    put("password", password);
    return this;
  }

  public JsonObject toJson() {
    return this;
  }
}
