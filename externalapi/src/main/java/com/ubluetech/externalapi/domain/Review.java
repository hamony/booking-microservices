package com.ubluetech.externalapi.domain;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Review {
    private String reviewerName;
    private int rating;
    private String comment;
    private LocalDateTime reviewDate;
}
