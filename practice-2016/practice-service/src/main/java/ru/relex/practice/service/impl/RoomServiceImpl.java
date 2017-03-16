package ru.relex.practice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.relex.practice.dao.FacilityDao;
import ru.relex.practice.dao.RoomDao;
import ru.relex.practice.dto.FacilityDTO;
import ru.relex.practice.dto.RoomDTO;
import ru.relex.practice.mappings.FacilityMapper;
import ru.relex.practice.mappings.RoomMapper;
import ru.relex.practice.model.Facility;
import ru.relex.practice.model.Room;
import ru.relex.practice.service.RoomService;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service("roomService")
public class RoomServiceImpl implements RoomService {
    @Autowired
    RoomDao roomDao;

    @Autowired
    RoomService roomService;

    @Autowired
    RoomMapper roomMapper;

    @Autowired
    FacilityDao facilityDao;

    @Autowired
    FacilityMapper facilityMapper;

    @Transactional
    @Override
    public RoomDTO saveRoom(String shortDescription,
                            String fullDescription,
                            Integer persons,
                            Integer numberOfRooms,
                            Long price,
                            Boolean isBooked,
                            Boolean isShown,
                            Boolean hasBreakfast,
                            String urlPhoto1, String urlPhoto2, String urlPhoto3,
                            Double ratingPosition, Double ratingComfort, Double ratingPrice, Double ratingQuality,
                            Double ratingAvg, Set<FacilityDTO> facilitiesDTO, String name) {

        Set<Facility> facilities = facilitiesDTO.stream().map(i -> facilityMapper.facilityDtoToFacility(i)).collect(Collectors.toSet());
        Room room = roomDao.createRoom(shortDescription,
                fullDescription,
                persons,
                numberOfRooms,
                price,
                isBooked,
                isShown,
                hasBreakfast,
                urlPhoto1,
                urlPhoto2,
                urlPhoto3,
                ratingPosition,
                ratingComfort,
                ratingPrice,
                ratingQuality,
                ratingAvg, facilities, name);
        return roomMapper.roomToDto(room);
    }
    
    @Transactional
    @Override
    public RoomDTO saveRoomFromJson(RoomDTO room) {
    	Room roomResponse = roomDao.createRoom(room.getShortDescription(),
    			room.getFullDescription(),
    			new Integer(room.getPersons()),
    			new Integer(room.getNumberOfRooms()),
    			new Long(room.getPrice()),
    			new Boolean(room.getisBooked()),
    			new Boolean(room.getisShown()),
    			new Boolean(room.getHasBreakfast()),
    			room.getUrlPhoto1(),
    			room.getUrlPhoto2(),
    			room.getUrlPhoto3(),
    			new Double(room.getRatingPosition()),
    			new Double(room.getRatingComfort()),
    			new Double(room.getRatingPrice()),
    			new Double(room.getRatingQuality()),
    			new Double(room.getRatingAvg()),
    			Collections.emptySet(),
    			room.getName());
    	return roomMapper.roomToDto(roomResponse);
    }

    @Transactional
    @Override
    public void removeRoom(Integer id) {
    	roomDao.deleteRoom(id);
    }
    
    @Transactional
    @Override
    public void updateFacilitiesForRoom(RoomDTO room) {
    	Set<Facility> facilities = facilityMapper.facilityEnumsToFacilities(room.getFacilities());
    	roomDao.updateFacilitiesForRoom(room.getId(), facilities);
    }
    
    @Transactional
    @Override
    public void updateRoom(RoomDTO room) {
    	Set<Facility> facilities = facilityMapper.facilityEnumsToFacilities(room.getFacilities());
    	roomDao.updateRoom(room.getId(),     			
    			room.getShortDescription(),
    			room.getFullDescription(),
    			room.getPersons(),
    			room.getNumberOfRooms(),
    			room.getPrice(),
    			room.getisBooked(),
    			room.getisShown(),
    			room.getHasBreakfast(),
    			room.getUrlPhoto1(), room.getUrlPhoto2(), room.getUrlPhoto3(),
    			room.getRatingPosition(), room.getRatingComfort(), room.getRatingPrice(), room.getRatingQuality(),
                new Double(0), facilities, room.getName());
    }
    
    @Override
    public List<RoomDTO> getRooms() {
        return roomMapper.roomsToDtos(roomDao.getRooms());
    }

    @Override
    public List<RoomDTO> getRooms(Integer id, Integer persons, Integer amountOfRooms, Integer prices, Boolean hasBreakfast) {
        return roomMapper.roomsToDtos(roomDao.getRooms(id, persons, amountOfRooms, prices, hasBreakfast));
    }

    @Override
    public List<RoomDTO> getTopFive() {
        return roomMapper.roomsToDtos(roomDao.getTopFive());
    }
}
