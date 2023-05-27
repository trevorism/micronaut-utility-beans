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

        if(authValue == null) {
            setToken("");
        }
        else{
            String tokenValue = authValue.substring(SecureHttpClient.BEARER_.length());
            setToken(tokenValue);
        }
    }
}
