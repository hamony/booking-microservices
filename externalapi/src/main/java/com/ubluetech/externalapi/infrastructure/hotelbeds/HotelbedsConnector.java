package com.ubluetech.externalapi.infrastructure.hotelbeds;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.Builder;

import com.google.common.hash.Hashing;
import com.ubluetech.externalapi.infrastructure.ClientConnectionException;
import com.ubluetech.externalapi.infrastructure.ClientManager;

import lombok.RequiredArgsConstructor;

import java.time.Instant;
import java.nio.charset.StandardCharsets;

@Component
@RequiredArgsConstructor
class HotelbedsConnector implements ClientManager {
    private final HotelbedsClientConfig clientConfig;
    private final Builder builder;

    @Override
    public WebClient getClient() {
        return getBuilder().build();
    }

    @Override
    public Builder getBuilder() throws ClientConnectionException {
        long currentTime = Instant.now().getEpochSecond();
        String signature = Hashing.sha256()
                                .hashString(clientConfig.getApiKey() + clientConfig.getApiSecret() + currentTime, StandardCharsets.UTF_8)
                                .toString();

        return builder.baseUrl(clientConfig.getUrl() + "/" + clientConfig.getContentType() + "/" + clientConfig.getVersion())
                .defaultHeaders(httpHeaders -> {
                            httpHeaders.add("Api-key", clientConfig.getApiKey());
                            httpHeaders.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON.toString());
                            httpHeaders.add(HttpHeaders.ACCEPT_ENCODING, "gzip");
                            httpHeaders.add("X-Signature", signature);
                });
    }
    
}
