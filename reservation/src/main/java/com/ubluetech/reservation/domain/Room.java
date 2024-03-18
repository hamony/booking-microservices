package com.ubluetech.reservation.domain;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import lombok.Getter;

@Getter
class Room {
    @Column(nullable = false)
    private String roomNumber;

    @Column(nullable = false)
    private BigDecimal price;
}
