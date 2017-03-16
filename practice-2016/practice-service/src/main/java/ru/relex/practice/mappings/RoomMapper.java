package ru.relex.practice.mappings;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import ru.relex.practice.dto.RoomDTO;
import ru.relex.practice.model.Room;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public abstract class RoomMapper {
    @Autowired
    FacilityMapper facilityMapper;


    @Mapping(source = "id", target = "id")
    @Mapping(source = "shortDescription", target = "shortDescription")
    @Mapping(source = "fullDescription", target = "fullDescription")
    @Mapping(source = "persons", target = "persons")
    @Mapping(source = "numberOfRooms", target = "numberOfRooms")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "isBooked", target = "isBooked")
    @Mapping(source = "isShown", target = "isShown")
    @Mapping(source = "hasBreakfast", target = "hasBreakfast")
    @Mapping(source = "urlPhoto1", target = "urlPhoto1")
    @Mapping(source = "urlPhoto2", target = "urlPhoto2")
    @Mapping(source = "urlPhoto3", target = "urlPhoto3")
    @Mapping(source = "ratingPosition", target = "ratingPosition")
    @Mapping(source = "ratingComfort", target = "ratingComfort")
    @Mapping(source = "ratingPrice", target = "ratingPrice")
    @Mapping(source = "ratingQuality", target = "ratingQuality")
    @Mapping(source = "ratingAvg", target = "ratingAvg")
    @Mapping(source = "name", target = "name")
    @Mapping(expression = "java(facilityMapper.facilitiesToFacilityEnums(room.getFacilities()))", target = "facilities")
    public abstract RoomDTO roomToDto(Room room);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "shortDescription", target = "shortDescription")
    @Mapping(source = "fullDescription", target = "fullDescription")
    @Mapping(source = "persons", target = "persons")
    @Mapping(source = "numberOfRooms", target = "numberOfRooms")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "isBooked", target = "isBooked")
    @Mapping(source = "isShown", target = "isShown")
    @Mapping(source = "hasBreakfast", target = "hasBreakfast")
    @Mapping(source = "urlPhoto1", target = "urlPhoto1")
    @Mapping(source = "urlPhoto2", target = "urlPhoto2")
    @Mapping(source = "urlPhoto3", target = "urlPhoto3")
    @Mapping(source = "ratingPosition", target = "ratingPosition")
    @Mapping(source = "ratingComfort", target = "ratingComfort")
    @Mapping(source = "ratingPrice", target = "ratingPrice")
    @Mapping(source = "ratingQuality", target = "ratingQuality")
    @Mapping(source = "ratingAvg", target = "ratingAvg")
    @Mapping(source = "name", target = "name")
    @Mapping(expression = "java(facilityMapper.facilityEnumsToFacilities(roomDTO.getFacilities()))", target = "facilities")
    public abstract Room roomDtoToRoom(RoomDTO roomDTO);

    public abstract List<RoomDTO>roomsToDtos(Collection<Room> rooms);

    public abstract List<Room> DtosToRooms(Collection<RoomDTO> roomDTOs);
}