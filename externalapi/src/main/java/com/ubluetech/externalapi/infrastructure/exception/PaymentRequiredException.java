package com.ubluetech.externalapi.infrastructure.exception;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.reactive.function.client.WebClientResponseException;

public class PaymentRequiredException extends WebClientResponseException {
    public PaymentRequiredException(String message, HttpStatusCode statusCode, String statusText) {
        super(message, statusCode, statusText, null, null, null, null);
    }
}
