package com.ubluetech.reservation.application;

import com.ubluetech.reservation.domain.Reservation;

public interface ReservationService {
    public boolean createReservation(Reservation reservation);
    public Reservation updateReservation(Long id, Reservation reservation);
    public boolean cancelReservation(Long id);
}
