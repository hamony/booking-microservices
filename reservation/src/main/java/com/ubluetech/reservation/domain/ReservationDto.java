package com.ubluetech.reservation.domain;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReservationDto {
    private Long reservationId;
    private String fullName;
    private String email;
    private String phoneNumber;

    private LocalDate checkInDate;
    private LocalDate checkOutDate;
}
