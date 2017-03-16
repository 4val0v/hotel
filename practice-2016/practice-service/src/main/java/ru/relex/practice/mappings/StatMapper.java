package ru.relex.practice.mappings;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.relex.practice.dto.StatDTO;
import ru.relex.practice.model.Stat;

import java.util.Collection;
import java.util.List;

/**
 *  11/25/2016.
 */
@Mapper(componentModel = "spring")
public abstract class StatMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "workDay", target = "workDay")
    @Mapping(source = "adultsNumber" , target = "adultsNumber")
    @Mapping(source = "childrenNumber" , target = "childrenNumber")
    @Mapping(source = "occupiedRoomsOne", target = "occupiedRoomsOne")
    @Mapping(source = "occupiedRoomsTwo", target = "occupiedRoomsTwo")
    @Mapping(source = "occupiedRoomsThree", target = "occupiedRoomsThree")
    @Mapping(source = "occupiedRoomsFour", target = "occupiedRoomsFour")
    @Mapping(source = "occupiedRoomsFive", target = "occupiedRoomsFive")
    public abstract StatDTO statToDto(Stat stat);


    @Mapping(source = "id", target = "id")
    @Mapping(source = "workDay", target = "workDay")
    @Mapping(source = "adultsNumber" , target = "adultsNumber")
    @Mapping(source = "childrenNumber" , target = "childrenNumber")
    @Mapping(source = "occupiedRoomsOne", target = "occupiedRoomsOne")
    @Mapping(source = "occupiedRoomsTwo", target = "occupiedRoomsTwo")
    @Mapping(source = "occupiedRoomsThree", target = "occupiedRoomsThree")
    @Mapping(source = "occupiedRoomsFour", target = "occupiedRoomsFour")
    @Mapping(source = "occupiedRoomsFive", target = "occupiedRoomsFive")
    public abstract Stat statDtoToStat(StatDTO statDTO);

    public abstract List<StatDTO>statsToDtos(Collection<Stat> stats);

    public abstract List<Stat> DtosToStats(Collection<StatDTO> statDTOs);


}
