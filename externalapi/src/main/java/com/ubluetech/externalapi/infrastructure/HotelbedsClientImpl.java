package com.ubluetech.externalapi.infrastructure;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

import com.ubluetech.externalapi.domain.Hotel;
import com.ubluetech.externalapi.domain.SearchCriteria;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;
import java.time.Instant;
import java.nio.charset.StandardCharsets;
import com.google.common.hash.Hashing;

@Component
@RequiredArgsConstructor
class HotelbedsClientImpl implements RemoteApiService {

    private final WebClient.Builder builder;
    private final HotelbedsMapper hotelbedsMapper;
    private final HotelbedsClientProperties clientProperties;

    @Override
    public Mono<PagedResponse<Hotel>> getAllHotels() {

        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        queryParams.add("fields", "all");
        queryParams.add("language", "ENG");
        queryParams.add("from", "1");
        queryParams.add("to", "3");
        queryParams.add("useSecondaryLanguage", "false");

    
        return buildWebClient().get()
                            .uri( uriBuilder -> uriBuilder
                                    .path("/hotels")
                                    .queryParams(queryParams)
                                    .build())
                            .retrieve()
                            .onStatus(HttpStatusCode::isError, this::handleHttpError)
                            .bodyToMono(new ParameterizedTypeReference<HotelbedsResponse<Hotelbeds>>() {})
                            .map(hotelbedsMapper::mapToHotelsResponse);
       
    }

    @Override
    public Mono<PagedResponse<Hotel>> searchHotels(SearchCriteria searchCriteria) {
        return getAllHotels();
    }

    private WebClient buildWebClient() {
        long currentTime = Instant.now().getEpochSecond();
        String signature = Hashing.sha256()
                                .hashString(clientProperties.getApiKey() + clientProperties.getApiSecret() + currentTime, StandardCharsets.UTF_8)
                                .toString();

        return builder.baseUrl(clientProperties.getUrl() + "/" + clientProperties.getContentType() + "/" + clientProperties.getVersion())
                .defaultHeaders(httpHeaders -> {
                                httpHeaders.add("Api-key", clientProperties.getApiKey());
                                httpHeaders.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON.toString());
                                httpHeaders.add(HttpHeaders.ACCEPT_ENCODING, "gzip");
                                httpHeaders.add("X-Signature", signature);
                            })
                .build();
    }

    private Mono<? extends Throwable> handleHttpError(ClientResponse response) {
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
