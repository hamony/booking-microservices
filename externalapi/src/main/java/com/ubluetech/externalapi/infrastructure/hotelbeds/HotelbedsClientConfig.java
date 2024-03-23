package com.ubluetech.externalapi.infrastructure.hotelbeds;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Component
@ConfigurationProperties(prefix = "hotelbeds")
@Validated
public class HotelbedsClientConfig {
    @NotBlank
    private String url;

    @NotBlank
    private String contentType;

    @NotBlank
    private String version;

    @NotBlank
    private String apiKey;
    
    @NotBlank
    private String apiSecret;
}
