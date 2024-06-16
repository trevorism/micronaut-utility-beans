package com.trevorism.bean;

import com.trevorism.http.HeadersHttpResponse;
import com.trevorism.http.HttpClient;
import com.trevorism.https.SecureHttpClient;
import com.trevorism.https.SecureHttpClientBase;
import jakarta.inject.Named;
import jakarta.inject.Singleton;

import java.util.HashMap;
import java.util.Map;

@Singleton
@Named("passThruSecureHttpClient")
public class PassThruSecureHttpClient extends SecureHttpClientBase implements SecureHttpClient {

    public PassThruSecureHttpClient(PassThruObtainTokenStrategy strategy) {
        super(strategy);
    }

    public PassThruSecureHttpClient(HttpClient delegate, PassThruObtainTokenStrategy strategy) {
        super(delegate, strategy);
    }

    @Override
    public HeadersHttpResponse get(String url, Map<String, String> map) {
        Map<String, String> headersMap = createHeaderMap();
        headersMap.putAll(map);
        return super.get(url, headersMap);
    }

    @Override
    public HeadersHttpResponse post(String url, String serialized, Map<String, String> map) {
        Map<String, String> headersMap = createHeaderMap();
        headersMap.putAll(map);
        return super.post(url, serialized, headersMap);
    }
    @Override
    public HeadersHttpResponse put(String url, String serialized, Map<String, String> map) {
        Map<String, String> headersMap = createHeaderMap();
        headersMap.putAll(map);
        return super.put(url, serialized, headersMap);
    }
    @Override
    public HeadersHttpResponse patch(String url, String serialized, Map<String, String> map) {
        Map<String, String> headersMap = createHeaderMap();
        headersMap.putAll(map);
        return super.patch(url, serialized, headersMap);
    }

    @Override
    public HeadersHttpResponse delete(String url, Map<String, String> map) {
        Map<String, String> headersMap = createHeaderMap();
        headersMap.putAll(map);
        return super.delete(url, headersMap);
    }

    @Override
    protected Map<String, String> createHeaderMap() {
        Map<String, String> headersMap = new HashMap<>();
        headersMap.put(AUTHORIZATION, SecureHttpClient.BEARER_ + this.getObtainTokenStrategy().getToken());
        return headersMap;
    }
}
