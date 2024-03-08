package com.ubluetech.externalapi.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ubluetech.externalapi.application.BookingService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/bookings")
@RequiredArgsConstructor
public class BookingController {
    
    private final BookingService bookingService;

    @PostMapping
    public void createBooking() {
        bookingService.createBooking();
    }
}
