package com.ubluetech.reservation.application;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ubluetech.reservation.domain.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    
}
