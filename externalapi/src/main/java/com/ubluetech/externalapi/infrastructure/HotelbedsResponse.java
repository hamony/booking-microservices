package com.ubluetech.externalapi.infrastructure;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
class HotelbedsResponse<T> {
    private int from;
    private int to;
    private int total;
    private AuditData auditData;
    private List<T> hotels;
}
