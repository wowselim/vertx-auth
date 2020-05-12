package io.vertx.ext.auth.ldap;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject
public class LDAPAuthInfo extends JsonObject {

  public LDAPAuthInfo() {
  }

  public LDAPAuthInfo(LDAPAuthInfo other) {
    mergeIn(other, true);
  }

  public LDAPAuthInfo(JsonObject json) {
    mergeIn(json, true);
  }

  public LDAPAuthInfo setUsername(String username) {
    put("username", username);
    return this;
  }

  public LDAPAuthInfo setPassword(String password) {
    put("password", password);
    return this;
  }

  public JsonObject toJson() {
    return this;
  }
}
