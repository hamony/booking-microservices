package com.ubluetech.externalapi.domain;

import java.time.LocalDate;
import java.math.BigDecimal;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SearchCriteria {
    private String location;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private int numberOfAdults;
    private int numberOfChildren;
    private int numberOfInfants;
    private RoomType roomType;
    private BigDecimal minPrice;
    private BigDecimal maxPrice;
    private Set<Amenity> amenities;
    private int minStarRating;
    private double maxDistance;
    private SortingCriteria sortingCriteria;
    private int pageSize;
    private int pageNumber;
}
