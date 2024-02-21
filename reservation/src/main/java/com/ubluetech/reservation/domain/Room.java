package com.ubluetech.reservation.domain;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable
@Getter
class Room {
    @Column(nullable = false)
    private String roomNumber;

    @Column(nullable = false)
    private BigDecimal price;
}
