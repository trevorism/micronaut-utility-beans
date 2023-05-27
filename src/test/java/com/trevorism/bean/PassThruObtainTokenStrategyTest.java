package com.trevorism.bean;

import com.trevorism.https.SecureHttpClient;
import io.micronaut.http.HttpMethod;
import io.micronaut.http.simple.SimpleHttpRequest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PassThruObtainTokenStrategyTest {

    @Test
    void testSetRequest() {
        SimpleHttpRequest<String> request = new SimpleHttpRequest<>(HttpMethod.GET, "/", "");
        request.header(SecureHttpClient.AUTHORIZATION, SecureHttpClient.BEARER_ + "1234");
        PassThruObtainTokenStrategy passThruObtainTokenStrategy = new PassThruObtainTokenStrategy();
        passThruObtainTokenStrategy.setRequest(request);
        assertEquals("1234", passThruObtainTokenStrategy.getToken());
    }
}