package com.trevorism.bean;

import io.micronaut.http.HttpMethod;
import io.micronaut.http.simple.SimpleHttpRequest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CorrelationIdProviderTest {

    @Test
    void testSetRequest() {
        CorrelationIdProvider correlationIdProvider = new CorrelationIdProvider();
        SimpleHttpRequest<String> request = new SimpleHttpRequest<>(HttpMethod.GET, "/", "");
        request.setAttribute(CorrelationIdProvider.X_CORRELATION_ID, "1234");
        correlationIdProvider.setRequest(request);
        assertEquals("1234", correlationIdProvider.getCorrelationId());
    }

    @Test
    void testGetCorrelationId() {
        CorrelationIdProvider correlationIdProvider = new CorrelationIdProvider();
        assertNotNull(correlationIdProvider.getCorrelationId());

    }
}