package com.ubluetech.externalapi.infrastructure;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
class Hotelbeds {
    private int code;
    private Address address;
    private String postalCode;
    private String email;
}
