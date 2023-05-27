package com.trevorism.bean;

import io.micronaut.http.HttpRequest;
import io.micronaut.runtime.http.scope.RequestAware;
import io.micronaut.runtime.http.scope.RequestScope;

import java.util.Optional;
import java.util.UUID;

@RequestScope
public class CorrelationIdProvider implements RequestAware{

    public static String X_CORRELATION_ID = "X-Correlation-ID";
    private String correlationId = UUID.randomUUID().toString();

    @Override
    public void setRequest(HttpRequest<?> request) {
        Optional<String> attr = request.getAttribute(X_CORRELATION_ID, String.class);
        attr.ifPresent(s -> correlationId = s);
    }

    public String getCorrelationId(){
        return correlationId;
    }
}
