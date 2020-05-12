package io.vertx.ext.auth.htpasswd;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject
public class HtPasswdAuthInfo extends JsonObject {

  public HtPasswdAuthInfo() {
  }

  public HtPasswdAuthInfo(HtPasswdAuthInfo other) {
    mergeIn(other, true);
  }

  public HtPasswdAuthInfo(JsonObject json) {
    mergeIn(json, true);
  }

  public HtPasswdAuthInfo setUsername(String username) {
    put("username", username);
    return this;
  }

  public HtPasswdAuthInfo setPassword(String password) {
    put("password", password);
    return this;
  }

  public JsonObject toJson() {
    return this;
  }
}
