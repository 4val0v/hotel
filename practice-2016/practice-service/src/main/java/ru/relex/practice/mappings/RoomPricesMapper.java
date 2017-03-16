package ru.relex.practice.mappings;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.relex.practice.dto.RoomPriceDTO;
import ru.relex.practice.model.RoomPrice;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public abstract class RoomPricesMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "roomId", target = "roomId")
    @Mapping(source = "priceTypeId", target = "priceTypeId")
    @Mapping(source = "dateBegin", target = "dateBegin")
    @Mapping(source = "dateEnd", target = "dateEnd")
    @Mapping(source = "price", target = "price")
    public abstract RoomPriceDTO roomPricesToDto(RoomPrice roomPrice);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "roomId", target = "roomId")
    @Mapping(source = "priceTypeId", target = "priceTypeId")
    @Mapping(source = "dateBegin", target = "dateBegin")
    @Mapping(source = "dateEnd", target = "dateEnd")
    @Mapping(source = "price", target = "price")
    public abstract RoomPrice roomPricesDtoToRoomPrices(RoomPriceDTO roomPriceDTO);

    public abstract List<RoomPriceDTO> roomsPricesToRoomPriceDtos(Collection<RoomPrice> roomsPrice);

    public abstract List<RoomPrice> roomsPriceDtosToRoomPrices(Collection<RoomPriceDTO> roomsPriceDto);
}
