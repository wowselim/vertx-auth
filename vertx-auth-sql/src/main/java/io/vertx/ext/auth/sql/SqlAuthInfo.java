package io.vertx.ext.auth.sql;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject
public class SqlAuthInfo extends JsonObject {

  public SqlAuthInfo() {
  }

  public SqlAuthInfo(SqlAuthInfo other) {
    mergeIn(other, true);
  }

  public SqlAuthInfo(JsonObject json) {
    mergeIn(json, true);
  }

  public SqlAuthInfo setUsername(String username) {
    put("username", username);
    return this;
  }

  public SqlAuthInfo setPassword(String password) {
    put("password", password);
    return this;
  }

  public JsonObject toJson() {
    return this;
  }
}
