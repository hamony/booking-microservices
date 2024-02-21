package com.ubluetech.reservation.domain;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "reservation")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Embedded
    private Guest guest;

    @Embedded
    private Room room;
    
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
}
