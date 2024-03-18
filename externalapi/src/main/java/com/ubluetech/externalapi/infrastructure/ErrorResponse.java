package com.ubluetech.externalapi.infrastructure;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class ErrorResponse {
    private String statusText;
    private String message;
    private int errorCode;
}
