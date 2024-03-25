package com.ubluetech.reservation.application;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ubluetech.reservation.domain.Reservation;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Transactional
@RequiredArgsConstructor
class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository repository;

    @Override
    public boolean createReservation(Reservation reservation) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createReservation'");
    }

    @Override
    public Reservation updateReservation(Long id, Reservation reservation) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateReservation'");
    }

    @Override
    public boolean cancelReservation(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cancelReservation'");
    }    
}
