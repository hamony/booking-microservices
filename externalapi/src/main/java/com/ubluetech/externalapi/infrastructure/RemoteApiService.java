package com.ubluetech.externalapi.infrastructure;

import com.ubluetech.externalapi.domain.Hotel;
import com.ubluetech.externalapi.domain.SearchCriteria;

import reactor.core.publisher.Mono;

public interface RemoteApiService {
    public Mono<PagedResponse<Hotel>> searchHotels(SearchCriteria searchCriteria);
    public Mono<PagedResponse<Hotel>> getAllHotels();
}
