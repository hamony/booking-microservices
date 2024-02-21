package com.ubluetech.reservation.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable
@Getter
class Guest {
    @Column(nullable = false)
    private String fullName;
    
    @Column(nullable = false)
    private String email;
    private String phoneNumber;
}
