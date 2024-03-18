package com.ubluetech.externalapi.infrastructure;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.reactive.function.client.WebClientResponseException;

public class UnauthorizedException extends WebClientResponseException {
    public UnauthorizedException(String message, HttpStatusCode statusCode, String statusText) {
        super(message, statusCode, statusText, null, null, null, null);
    }
}
