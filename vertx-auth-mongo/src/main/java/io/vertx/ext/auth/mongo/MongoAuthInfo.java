package io.vertx.ext.auth.mongo;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject
public class MongoAuthInfo extends JsonObject {

  public MongoAuthInfo() {
  }

  public MongoAuthInfo(MongoAuthInfo other) {
    mergeIn(other, true);
  }

  public MongoAuthInfo(JsonObject json) {
    mergeIn(json, true);
  }

  public MongoAuthInfo setUsername(String username) {
    put("username", username);
    return this;
  }

  public MongoAuthInfo setPassword(String password) {
    put("password", password);
    return this;
  }

  public JsonObject toJson() {
    return this;
  }
}
