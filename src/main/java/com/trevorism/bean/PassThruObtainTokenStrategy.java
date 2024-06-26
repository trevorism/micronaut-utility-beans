package com.trevorism.bean;

import com.trevorism.https.SecureHttpClient;
import com.trevorism.https.token.ObtainTokenFromParameter;
import io.micronaut.http.HttpRequest;
import io.micronaut.runtime.http.scope.RequestAware;
import io.micronaut.runtime.http.scope.RequestScope;

@RequestScope
public class PassThruObtainTokenStrategy extends ObtainTokenFromParameter implements RequestAware {

    @Override
    public void setRequest(HttpRequest<?> request) {
        String authValue = request.getHeaders().get(SecureHttpClient.AUTHORIZATION);

        if (bearerTokenDoesNotExistInAuthHeader(authValue)) {
            setToken(getAuthTokenFromSessionCookie(request));
        } else {
            setToken(getAuthTokenFromAuthValue(authValue));
        }
    }

    private static String getAuthTokenFromAuthValue(String authValue) {
        try {
            return authValue.substring(SecureHttpClient.BEARER_.length());
        } catch (Exception ignored) {
            return "";
        }
    }

    private String getAuthTokenFromSessionCookie(HttpRequest<?> request) {
        try {
            return request.getCookies().get("session").getValue();
        } catch (Exception ignored) {
            return "";
        }
    }

    private static boolean bearerTokenDoesNotExistInAuthHeader(String authValue) {
        return authValue == null || authValue.isEmpty();
    }
}
