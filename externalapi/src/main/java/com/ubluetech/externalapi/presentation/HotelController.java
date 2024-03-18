package com.ubluetech.externalapi.presentation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ubluetech.externalapi.application.HotelService;
import com.ubluetech.externalapi.domain.Hotel;
import com.ubluetech.externalapi.domain.SearchCriteria;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import java.time.LocalDate;

@RestController
@RequestMapping("/api/hotels")
@RequiredArgsConstructor
public class HotelController {
    private final HotelService hotelService;
    
    @GetMapping
    public ResponseEntity<Flux<Hotel>> searchHotels(
        @RequestParam(name = "checkInDate", required = false) final LocalDate checkInDate
        , @RequestParam(name = "checkOutDate", required = false) final LocalDate checkOutDate
        ) {
        SearchCriteria criteria = new SearchCriteria();
        return ResponseEntity.ok(hotelService.searchHotels(criteria));
    }
    
}
