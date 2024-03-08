package com.ubluetech.externalapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import com.google.common.hash.Hashing;
import java.sql.Timestamp;
import java.nio.charset.StandardCharsets;

@Configuration
public class WebClientConfig {
    private static final String HOTELBEDS_API_URL = "https://api.test.hotelbeds.com";
    private static final String HOTELBEDS_API_CONTENT_TYPE = "hotel-content-api";
    private static final String HOTELBEDS_API_VERSION = "1.0";
    private static final String HOTELBEDS_API_KEY = "44a91ec4395b6807f685493a295dd4eb";
    private static final String HOTELBEDS_API_SECRET = "4ac67de07b";

    @Bean
    public WebClient webClient() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String signature = Hashing.sha256()
                                .hashString(HOTELBEDS_API_KEY + HOTELBEDS_API_SECRET + timestamp.getTime() / 1000, StandardCharsets.UTF_8)
                                .toString();
                                
        return WebClient.builder()
                        .baseUrl(HOTELBEDS_API_URL + "/" + HOTELBEDS_API_CONTENT_TYPE + "/" + HOTELBEDS_API_VERSION)
                        .defaultHeaders(httpHeaders -> {
                            httpHeaders.add("Api-key", HOTELBEDS_API_KEY);
                            httpHeaders.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON.toString());
                            httpHeaders.add(HttpHeaders.ACCEPT_ENCODING, "gzip");
                            httpHeaders.add("X-Signature", signature);
                        })
                        .build();
    }
}
