package com.ubluetech.externalapi.infrastructure.exception;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.reactive.function.client.WebClientResponseException;

public class InternalServerErrorException extends WebClientResponseException {
    public InternalServerErrorException(String message, HttpStatusCode statusCode, String statusText) {
        super(message, statusCode, statusText, null, null, null, null);
    }
}
