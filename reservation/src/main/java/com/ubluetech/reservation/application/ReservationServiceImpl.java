package com.ubluetech.reservation.application;

import com.ubluetech.reservation.domain.Reservation;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Transactional
@RequiredArgsConstructor
class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository repository;

    @Override
    public boolean createReservation(Reservation reservation) {
        throw new UnsupportedOperationException("Unimplemented method 'createReservation'");
    }

    @Override
    public Reservation updateReservation(Long id, Reservation reservation) {
        throw new UnsupportedOperationException("Unimplemented method 'updateReservation'");
    }

    @Override
    public boolean cancelReservation(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'cancelReservation'");
    }    
}
