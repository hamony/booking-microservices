package com.ubluetech.externalapi.application;

import org.springframework.stereotype.Service;

import com.ubluetech.externalapi.domain.BookingDetails;
import com.ubluetech.externalapi.domain.BookingRequest;
import com.ubluetech.externalapi.domain.BookingResponse;

@Service
class BookingServiceImpl implements BookingService {

    @Override
    public BookingResponse createBooking() {
        throw new UnsupportedOperationException("Unimplemented method 'createBooking'");
    }

    @Override
    public boolean updateBooking(int bookingId, BookingRequest request) {
        throw new UnsupportedOperationException("Unimplemented method 'updateBooking'");
    }

    @Override
    public boolean cancelBooking(int bookingId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cancelBooking'");
    }

    @Override
    public BookingDetails getBookingById(int bookingId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBookingById'");
    }
    
}
