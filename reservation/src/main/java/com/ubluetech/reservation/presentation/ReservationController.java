package com.ubluetech.reservation.presentation;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ubluetech.reservation.application.ReservationRepository;
import com.ubluetech.reservation.domain.ReservationDto;
import com.ubluetech.reservation.domain.ReservationMapper;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/reservations")
@RequiredArgsConstructor
public class ReservationController {
    private final ReservationRepository repository;
    private final ReservationMapper reservationMapper;

    @GetMapping
    public List<ReservationDto> getAllReservations() {
        return repository.
                findAll()
                .stream()
                .map(reservationMapper::entityToDto)
                .toList();
    }
    
    @GetMapping("/{id}")
    public ReservationDto getReservation(@PathVariable(value = "id") Long id) {
        return reservationMapper
                .entityToDto(
                    repository
                        .findById(id)
                        .orElse(null)
                );
    }
}
