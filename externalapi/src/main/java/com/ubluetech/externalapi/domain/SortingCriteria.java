package com.ubluetech.externalapi.domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SortingCriteria {
    private String field;
    private SortDirection direction;
}
