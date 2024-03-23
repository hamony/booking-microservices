package com.ubluetech.externalapi.infrastructure;

import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.Builder;
import org.springframework.web.reactive.function.client.WebClientException;

public interface ClientManager {
    public WebClient getClient() throws WebClientException;
    public Builder getBuilder() throws ClientConnectionException;
}
