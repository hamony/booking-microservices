package com.ubluetech.reservation.domain;

import jakarta.persistence.Column;
import lombok.Getter;

@Getter
class Guest {
    @Column(nullable = false)
    private String fullName;
    
    @Column(nullable = false)
    private String email;
    private String phoneNumber;
}
