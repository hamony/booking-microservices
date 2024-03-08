package com.ubluetech.externalapi.application;

import org.springframework.stereotype.Service;

import com.ubluetech.externalapi.domain.Hotel;
import com.ubluetech.externalapi.domain.SearchCriteria;
import com.ubluetech.externalapi.infrastructure.PagedResponse;
import com.ubluetech.externalapi.infrastructure.RemoteApiService;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;

@Service
@AllArgsConstructor
public class HotelServiceImpl implements HotelService {
    private final RemoteApiService remoteApiService;

    @Override
    public Flux<Hotel> searchHotels(SearchCriteria criteria) {
        return remoteApiService.searchHotels(criteria)
                                .map(PagedResponse::getContent)
                                .flatMapMany(Flux::fromIterable);
    }
    
}
