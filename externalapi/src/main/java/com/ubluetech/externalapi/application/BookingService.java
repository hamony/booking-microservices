package com.ubluetech.externalapi.application;

import com.ubluetech.externalapi.domain.BookingDetails;
import com.ubluetech.externalapi.domain.BookingRequest;
import com.ubluetech.externalapi.domain.BookingResponse;

public interface BookingService {
    public BookingResponse createBooking();
    public boolean updateBooking(int bookingId, BookingRequest request);
    public BookingDetails getBookingById(int bookingId);
    public boolean cancelBooking(int bookingId);
}
