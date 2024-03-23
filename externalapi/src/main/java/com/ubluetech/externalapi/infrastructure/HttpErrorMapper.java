package com.ubluetech.externalapi.infrastructure;

import org.springframework.web.reactive.function.client.ClientResponse;

import com.ubluetech.externalapi.infrastructure.exception.BadRequestException;
import com.ubluetech.externalapi.infrastructure.exception.InternalServerErrorException;
import com.ubluetech.externalapi.infrastructure.exception.PaymentRequiredException;
import com.ubluetech.externalapi.infrastructure.exception.ServiceUnavailableException;
import com.ubluetech.externalapi.infrastructure.exception.UnauthorizedException;
import com.ubluetech.externalapi.infrastructure.exception.UnexpectedException;

import reactor.core.publisher.Mono;

public class HttpErrorMapper {
    private HttpErrorMapper(){}

    public static Mono<? extends Throwable> handleHttpError(ClientResponse response) {
        return response.createException().flatMap(ex -> {
            int statusCode = ex.getStatusCode().value();
            return switch (statusCode) {
                case 400 -> Mono.error(new BadRequestException("Bad Request: " + ex.getMessage(), ex.getStatusCode(), ex.getStatusText()));
                case 401 -> Mono.error(new UnauthorizedException("Unauthorized: " + ex.getMessage(), ex.getStatusCode(), ex.getStatusText()));
                case 402 -> Mono.error(new PaymentRequiredException("Payment Required: " + ex.getMessage(), ex.getStatusCode(), ex.getStatusText()));
                case 500 -> Mono.error(new InternalServerErrorException("Internal Server Error: " + ex.getMessage(), ex.getStatusCode(), ex.getStatusText()));
                case 503 -> Mono.error(new ServiceUnavailableException("Service Unavailable: " + ex.getMessage(), ex.getStatusCode(), ex.getStatusText()));
                default -> Mono.error(new UnexpectedException("Unexpected error: " + ex.getMessage(), ex.getStatusCode(), ex.getStatusText()));
            };
        });
    }
}
