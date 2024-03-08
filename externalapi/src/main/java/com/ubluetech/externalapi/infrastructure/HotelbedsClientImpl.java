package com.ubluetech.externalapi.infrastructure;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.ubluetech.externalapi.domain.Hotel;
import com.ubluetech.externalapi.domain.SearchCriteria;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class HotelbedsClientImpl implements RemoteApiService {

    private final WebClient webClient;
    private final HotelbedsMapper hotelbedsMapper;

    @Override
    public Mono<PagedResponse<Hotel>> getAllHotels() {
        final ParameterizedTypeReference<HotelbedsResponse<Hotelbeds>> hotelbedsResponse = new ParameterizedTypeReference<HotelbedsResponse<Hotelbeds>>() {};

        return webClient.get()
                        .uri("/hotels?fields=all&language=ENG&from=1&to=1&useSecondaryLanguage=false")
                        .retrieve()
                        .bodyToMono(hotelbedsResponse)
                        .map(hotelbedsMapper::mapToHotelsResponse);
    }

    @Override
    public Mono<PagedResponse<Hotel>> searchHotels(SearchCriteria searchCriteria) {
        return getAllHotels();
    }
}
