package io.vertx.ext.auth.test.oauth2;

import io.vertx.ext.auth.JWTOptions;
import io.vertx.ext.auth.oauth2.OAuth2Auth;
import io.vertx.ext.auth.oauth2.OAuth2Options;
import io.vertx.ext.auth.oauth2.impl.OAuth2AuthProviderImpl;
import io.vertx.ext.auth.oauth2.providers.*;
import io.vertx.test.core.VertxTestBase;
import org.junit.Ignore;
import org.junit.Test;

public class OpenIDCDiscoveryTest extends VertxTestBase {


  @Override
  public void setUp() throws Exception {
    super.setUp();
  }

  @Test
  public void testGoogle() {
    GoogleAuth.discover(vertx, new OAuth2Options(), load -> {
      // will fail as there is no application config, but the parsing should have happened
      assertTrue(load.failed());
      assertEquals("Configuration missing. You need to specify [clientId]", load.cause().getMessage());
      testComplete();
    });
    await();
  }

  @Test
  public void testMicrosoft() {
    AzureADAuth.discover(vertx, new OAuth2Options().setTenant("common"), load -> {
      // will fail as there is no application config, but the parsing should have happened
      assertTrue(load.failed());
      assertEquals("Configuration missing. You need to specify [clientId]", load.cause().getMessage());
      testComplete();
    });
    await();
  }

  @Test
  public void testSalesforce() {
    SalesforceAuth.discover(vertx, new OAuth2Options(), load -> {
      // will fail as there is no application config, but the parsing should have happened
      assertTrue(load.failed());
      assertEquals("Configuration missing. You need to specify [clientId]", load.cause().getMessage());
      testComplete();
    });
    await();
  }


  @Test
  public void testIBMCloud() {
    IBMCloudAuth.discover(
      vertx,
      new OAuth2Options()
        .setSite("https://us-south.appid.cloud.ibm.com/oauth/v4/{tenant}")
        .setTenant("39a37f57-a227-4bfe-a044-93b6e6060b61"),
      load -> {
        // will fail as there is no application config, but the parsing should have happened
        assertTrue(load.failed());
        assertEquals("Not Found: {\"status\":404,\"error_description\":\"Invalid TENANT ID\",\"error_code\":\"INVALID_TENANTID\"}", load.cause().getMessage());
        testComplete();
      });
    await();
  }

  @Test
  @Ignore
  public void testAmazonCognito() {
    AmazonCognitoAuth.discover(
      vertx,
      new OAuth2Options()
        .setSite("https://cognito-idp.eu-central-1.amazonaws.com/{tenant}")
        .setClientID("the-client-id")
        .setClientSecret("the-client-secret")
        .setTenant("user-pool-id"),
      load -> {
        // will fail as there is no application config, but the parsing should have happened
        testComplete();
      });
    await();
  }

  @Test
  public void testAzureConfigOverride() {
    AzureADAuth.discover(
      vertx,
      new OAuth2Options()
        // force v2.0
        .setSite("https://login.microsoftonline.com/{tenant}/v2.0")
        .setClientID("client-id")
        .setClientSecret("client-secret")
        .setTenant("common")
        // for extra security enforce the audience validation
        .setJWTOptions(new JWTOptions()
          .addAudience("api://client-id")), discovery -> {

        assertTrue(discovery.succeeded());
        OAuth2Options config = ((OAuth2AuthProviderImpl) discovery.result()).getConfig();
        // should merge not override!
        JWTOptions jwtOptions = config.getJWTOptions();
        assertEquals("api://client-id", jwtOptions.getAudience().get(0));
        System.out.println(jwtOptions.getAudience());
        testComplete();
      });
    await();
  }
}
