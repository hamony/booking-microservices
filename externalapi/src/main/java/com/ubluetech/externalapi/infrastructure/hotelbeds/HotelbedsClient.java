package com.ubluetech.externalapi.infrastructure.hotelbeds;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.ubluetech.externalapi.domain.Hotel;
import com.ubluetech.externalapi.domain.SearchCriteria;
import com.ubluetech.externalapi.infrastructure.PagedResponse;
import com.ubluetech.externalapi.infrastructure.BookingClient;
import com.ubluetech.externalapi.infrastructure.ClientManager;
import com.ubluetech.externalapi.infrastructure.HttpErrorMapper;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class HotelbedsClient implements BookingClient {
    private final HotelbedsMapper hotelbedsMapper;
    private final ClientManager clientManager;

    @Override
    public Mono<PagedResponse<Hotel>> getAllHotels() {

        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        queryParams.add("fields", "all");
        queryParams.add("language", "ENG");
        queryParams.add("from", "1");
        queryParams.add("to", "3");
        queryParams.add("useSecondaryLanguage", "false");

    
        return clientManager.getClient()
                            .get()
                            .uri( uriBuilder -> uriBuilder
                                    .path("/hotels")
                                    .queryParams(queryParams)
                                    .build())
                            .retrieve()
                            .onStatus(HttpStatusCode::isError, HttpErrorMapper::handleHttpError)
                            .bodyToMono(new ParameterizedTypeReference<HotelbedsResponse<Hotelbeds>>() {})
                            .map(hotelbedsMapper::mapToHotelsResponse);
       
    }

    @Override
    public Mono<PagedResponse<Hotel>> searchHotels(SearchCriteria searchCriteria) {
        return getAllHotels();
    }
}
