package com.ubluetech.reservation.domain;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ReservationMapper {
    ReservationMapper INSTANCE = Mappers.getMapper(ReservationMapper.class);

    @Mapping(target = "reservationId", source = "reservation.id")
    @Mapping(target = "fullName", source = "reservation.guest.fullName")
    @Mapping(target = "email", source = "reservation.guest.email")
    @Mapping(target = "phoneNumber", source = "reservation.guest.phoneNumber")
    ReservationDto entityToDto(Reservation reservation);
}
