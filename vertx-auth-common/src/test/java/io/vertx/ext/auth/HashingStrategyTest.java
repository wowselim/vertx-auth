package io.vertx.ext.auth;

import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;

import static org.junit.Assert.*;

public class HashingStrategyTest {

  Base64.Encoder B64ENC = Base64.getEncoder();

  String salt = B64ENC.encodeToString("keyboard.cat".getBytes(StandardCharsets.UTF_8));

  @Test
  public void testHashSimple() {
    HashingStrategy strategy = HashingStrategy.load();
    // should encode
    String hash = strategy.hash("sha512", null, salt, "SuperSecret$!");
    // should be valid
    assertTrue(strategy.verify(hash, "SuperSecret$!"));
    // should be wrong
    assertFalse(strategy.verify(hash, "superSecret$!"));
  }

  @Test
  public void testHashSHA1() {
    HashingStrategy strategy = HashingStrategy.load();
    assertNotNull(strategy.get("sha1"));
    // should encode
    String hash = strategy.hash("sha1", null, salt, "SuperSecret$!");
    // should be valid
    assertTrue(strategy.verify(hash, "SuperSecret$!"));
    // should be wrong
    assertFalse(strategy.verify(hash, "superSecret$!"));
  }

  @Test
  public void testHashSHA256() {
    HashingStrategy strategy = HashingStrategy.load();
    assertNotNull(strategy.get("sha256"));
    // should encode
    String hash = strategy.hash("sha256", null, salt, "SuperSecret$!");
    // should be valid
    assertTrue(strategy.verify(hash, "SuperSecret$!"));
    // should be wrong
    assertFalse(strategy.verify(hash, "superSecret$!"));
  }

  @Test
  public void testHashStronger() {
    HashingStrategy strategy = HashingStrategy.load();
    // should encode
    String hash = strategy.hash("pbkdf2", null, salt, "SuperSecret$!");
    // should be valid
    assertTrue(strategy.verify(hash, "SuperSecret$!"));
    // should be wrong
    assertFalse(strategy.verify(hash, "superSecret$!"));
    HashMap<String, String> params = new HashMap<String, String>();
    params.put("it", "100000");
    String hashWithPararms = strategy.hash("pbkdf2", params, salt, "SuperSecret$!");
    // should be different
    assertNotEquals(hash, hashWithPararms);
    // should be valid
    assertTrue(strategy.verify(hash, "SuperSecret$!"));
    // should be wrong
    assertFalse(strategy.verify(hash, "superSecret$!"));

  }
}
