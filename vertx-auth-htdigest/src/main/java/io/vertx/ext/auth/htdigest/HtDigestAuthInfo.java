package io.vertx.ext.auth.htdigest;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject
public class HtDigestAuthInfo extends JsonObject {

  public HtDigestAuthInfo() {
  }

  public HtDigestAuthInfo(HtDigestAuthInfo other) {
    mergeIn(other, true);
  }

  public HtDigestAuthInfo(JsonObject json) {
    mergeIn(json, true);
  }

  public HtDigestAuthInfo setUsername(String value) {
    put("username", value);
    return this;
  }

  public HtDigestAuthInfo setRealm(String value) {
    put("realm", value);
    return this;
  }

  public HtDigestAuthInfo setAlgorithm(String value) {
    put("algorithm", value);
    return this;
  }

  public HtDigestAuthInfo setNonce(String value) {
    put("nonce", value);
    return this;
  }

  public HtDigestAuthInfo setCnonce(String value) {
    put("cnonce", value);
    return this;
  }

  public HtDigestAuthInfo setQop(String value) {
    put("qop", value);
    return this;
  }

  public HtDigestAuthInfo setMethod(String value) {
    put("method", value);
    return this;
  }

  public HtDigestAuthInfo setUri(String value) {
    put("uri", value);
    return this;
  }

  public HtDigestAuthInfo setNc(String value) {
    put("nc", value);
    return this;
  }

  public HtDigestAuthInfo setResponse(String value) {
    put("response", value);
    return this;
  }

  public JsonObject toJson() {
    return this;
  }
}
