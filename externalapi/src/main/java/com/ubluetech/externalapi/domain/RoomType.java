package com.ubluetech.externalapi.domain;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RoomType {
    private String category;
    private String description;
    private int capacity;
    private List<String> amenities;
    private double price;
}
