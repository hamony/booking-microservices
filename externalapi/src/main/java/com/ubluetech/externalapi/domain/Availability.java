package com.ubluetech.externalapi.domain;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Availability {
    private LocalDate startDate;
    private LocalDate enDate;
    private RoomType roomType;
    private boolean available;
    private double price;
}
