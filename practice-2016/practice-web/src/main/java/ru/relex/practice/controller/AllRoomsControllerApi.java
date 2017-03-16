package ru.relex.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.relex.practice.dto.RoomDTO;
import ru.relex.practice.service.RoomService;

@Controller
/*@RequestMapping("/api/rooms")*/
@RequestMapping("/api_rooms")
public class AllRoomsControllerApi {
	
	@Autowired
    RoomService service;

    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody String addRoom(@RequestBody RoomDTO room) {
    	RoomDTO roomOut = service.saveRoomFromJson(room);
    	return  "{ id: " + roomOut.getId() + " }";
    }
    
    @RequestMapping(value = "/remove", method = RequestMethod.GET)
    public @ResponseBody String removeRoom(@RequestParam(value = "id") Integer id) {
    	service.removeRoom(id);
    	return  "room has been deleted";
    }
    
    @RequestMapping(value = "/update_facilities", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody String updateFacilitiesForRoom(@RequestBody RoomDTO room) {
    	service.updateFacilitiesForRoom(room);
    	return  "facilities for room "+ room.getId() + " has been updated";
    }
    
    @RequestMapping(value = "/update", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody String updateRoom(@RequestBody RoomDTO room) {
    	service.updateRoom(room);
    	return  "room "+ room.getId() + " has been updated";
    }
}
