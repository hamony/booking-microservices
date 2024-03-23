package com.ubluetech.externalapi.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ubluetech.externalapi.infrastructure.BookingClient;
import com.ubluetech.externalapi.infrastructure.ClientManager;
import com.ubluetech.externalapi.infrastructure.expedia.ExpediaClient;
import com.ubluetech.externalapi.infrastructure.hotelbeds.HotelbedsMapper;

import lombok.RequiredArgsConstructor;

import com.ubluetech.externalapi.infrastructure.hotelbeds.HotelbedsClient;

@Configuration
@RequiredArgsConstructor
public class BookingConfig {
    private final HotelbedsMapper hotelbedsMapper;
    private final ClientManager providerConnection;

    @Bean
    @ConditionalOnProperty(name = "booking.client", havingValue = "hotelbeds")
    public BookingClient hotelbedsClient() {
        return new HotelbedsClient(hotelbedsMapper, providerConnection);
    }

    @Bean
    @ConditionalOnProperty(name = "booking.client", havingValue = "expedia")
    public BookingClient expediaClient() {
        return new ExpediaClient();
    }
}
