package com.ubluetech.externalapi.domain;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class Hotel {
    private String id;
    private String name;
    private String address;
    private String description;
    private int rating;
    private List<String> images;
    private List<String> facilities;
    private List<RoomType> roomTypes;
    private List<Availability> availability;
    private String phoneNumber;
    private String email;
    private String website;
    private List<Review> reviews;
    private double latitude;
    private double longitude;

}
