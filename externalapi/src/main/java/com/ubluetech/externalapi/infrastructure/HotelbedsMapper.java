package com.ubluetech.externalapi.infrastructure;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import java.util.List;

import com.ubluetech.externalapi.domain.Hotel;

@Mapper(componentModel = "spring")
public interface HotelbedsMapper {
    HotelbedsMapper INSTANCE = Mappers.getMapper(HotelbedsMapper.class);

    @Mapping(target = "id", source = "hotelbeds.code")
    @Mapping(target = "address", source = "hotelbeds.address.content")
    Hotel mapToHotel(Hotelbeds hotelbeds);

    List<Hotel> mapToHotels(List<Hotelbeds> hotelbeds);

    @Mapping(target = "totalPages", source = "hotelbedsResponse.total")
    @Mapping(target = "content", source = "hotelbedsResponse.hotels")
    PagedResponse<Hotel> mapToHotelsResponse(HotelbedsResponse<Hotelbeds> hotelbedsResponse);
}
