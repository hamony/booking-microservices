package com.ubluetech.reservation.application;

import org.springframework.stereotype.Service;

import com.ubluetech.reservation.domain.Reservation;

@Service
public interface ReservationService {
    public boolean createReservation(Reservation reservation);
    public Reservation updateReservation(Long id, Reservation reservation);
    public boolean cancelReservation(Long id);
}
