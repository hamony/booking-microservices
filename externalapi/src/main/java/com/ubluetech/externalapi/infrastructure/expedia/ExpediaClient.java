package com.ubluetech.externalapi.infrastructure.expedia;

import com.ubluetech.externalapi.domain.Hotel;
import com.ubluetech.externalapi.domain.SearchCriteria;
import com.ubluetech.externalapi.infrastructure.BookingClient;
import com.ubluetech.externalapi.infrastructure.PagedResponse;

import reactor.core.publisher.Mono;

public class ExpediaClient implements BookingClient {

    @Override
    public Mono<PagedResponse<Hotel>> searchHotels(SearchCriteria searchCriteria) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchHotels'");
    }

    @Override
    public Mono<PagedResponse<Hotel>> getAllHotels() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllHotels'");
    }

}
