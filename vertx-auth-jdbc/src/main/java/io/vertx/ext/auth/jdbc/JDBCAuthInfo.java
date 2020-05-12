package io.vertx.ext.auth.jdbc;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject
public class JDBCAuthInfo extends JsonObject {

  public JDBCAuthInfo() {
  }

  public JDBCAuthInfo(JDBCAuthInfo other) {
    mergeIn(other, true);
  }

  public JDBCAuthInfo(JsonObject json) {
    mergeIn(json, true);
  }

  public JDBCAuthInfo setUsername(String username) {
    put("username", username);
    return this;
  }

  public JDBCAuthInfo setPassword(String password) {
    put("password", password);
    return this;
  }

  public JsonObject toJson() {
    return this;
  }
}
