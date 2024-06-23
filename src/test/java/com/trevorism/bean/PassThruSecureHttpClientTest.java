package com.trevorism.bean;

import com.trevorism.http.HeadersHttpResponse;
import com.trevorism.http.HttpClient;
import com.trevorism.https.SecureHttpClient;
import io.micronaut.http.HttpMethod;
import io.micronaut.http.simple.SimpleHttpRequest;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class PassThruSecureHttpClientTest {

    @Test
    void testGetAndPost() {
        PassThruSecureHttpClient passThruSecureHttpClient = new PassThruSecureHttpClient(new EchoHttpClient(), new PassThruObtainTokenStrategy());
        assertEquals("/", passThruSecureHttpClient.get("/"));
        assertEquals("{}", passThruSecureHttpClient.post("/","{}"));
    }

    @Test
    void testGetAndPostWithInjection() {
        PassThruObtainTokenStrategy passThruObtainTokenStrategy = new PassThruObtainTokenStrategy();

        SimpleHttpRequest<String> simpleHttpRequest = new SimpleHttpRequest<>(HttpMethod.GET, "/", "");
        simpleHttpRequest.header(SecureHttpClient.AUTHORIZATION, SecureHttpClient.BEARER_ + "1234");

        PassThruSecureHttpClient passThruSecureHttpClient = new PassThruSecureHttpClient(new EchoHttpClient(), passThruObtainTokenStrategy);
        passThruObtainTokenStrategy.setRequest(simpleHttpRequest);

        assertEquals("Bearer 1234", passThruSecureHttpClient.get("/", new HashMap<>()).getHeaders().get(SecureHttpClient.AUTHORIZATION));
        assertEquals("Bearer 1234", passThruSecureHttpClient.post("/","{}", new HashMap<>()).getHeaders().get(SecureHttpClient.AUTHORIZATION));


    }

    class EchoHttpClient implements HttpClient{

        @Override
        public String get(String s) {
            return s;
        }

        @Override
        public HeadersHttpResponse get(String s, Map<String, String> map) {
            return new HeadersHttpResponse(s, map);
        }

        @Override
        public String post(String s, String s1) {
            return s1;
        }

        @Override
        public HeadersHttpResponse post(String s, String s1, Map<String, String> map) {
            return new HeadersHttpResponse(s1, map);
        }

        @Override
        public String put(String s, String s1) {
            return s1;
        }

        @Override
        public HeadersHttpResponse put(String s, String s1, Map<String, String> map) {
            return new HeadersHttpResponse(s1, map);
        }

        @Override
        public String patch(String s, String s1) {
            return s1;
        }

        @Override
        public HeadersHttpResponse patch(String s, String s1, Map<String, String> map) {
            return new HeadersHttpResponse(s1, map);
        }

        @Override
        public String delete(String s) {
            return s;
        }

        @Override
        public HeadersHttpResponse delete(String s, Map<String, String> map) {
            return new HeadersHttpResponse(s, map);
        }
    }
}