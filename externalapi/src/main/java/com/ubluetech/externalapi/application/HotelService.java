package com.ubluetech.externalapi.application;

import com.ubluetech.externalapi.domain.Hotel;
import com.ubluetech.externalapi.domain.SearchCriteria;

import reactor.core.publisher.Flux;

public interface HotelService {
    Flux<Hotel> searchHotels(SearchCriteria criteria);
}
