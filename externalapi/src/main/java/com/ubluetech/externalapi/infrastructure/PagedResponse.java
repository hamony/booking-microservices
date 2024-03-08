package com.ubluetech.externalapi.infrastructure;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class PagedResponse<T> {
    private List<T> content;
    private int totalPages;
    private int totalElements;
    private int size;
    private int numberOfElements;
}
