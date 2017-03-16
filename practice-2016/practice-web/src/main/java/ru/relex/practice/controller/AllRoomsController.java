package ru.relex.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.relex.practice.dto.RoomDTO;
import ru.relex.practice.service.RoomPricesService;
import ru.relex.practice.service.RoomService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("/rooms")
public class AllRoomsController {

    @Autowired
    RoomService service;

    @Autowired
    RoomPricesService servicePrice;

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<RoomDTO> roomsPage(){
        return service.getRooms();
    }

    @RequestMapping(value = "/id", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody RoomDTO roomPage(@RequestParam(value = "id") Integer id){
        return service.getRooms(id, null,null,null,null).get(0);
    }

    @RequestMapping(value = "/coast", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody String coast(@RequestParam(value = "dateBegin") String dateBegin, @RequestParam(value = "dateEnd") String dateEnd, @RequestParam(value = "id") Integer id){
        return "{\"coast\":"+servicePrice.getCoast(id,LocalDate.parse(dateBegin, DateTimeFormatter.ofPattern("yyyy-MM-dd")),LocalDate.parse(dateEnd, DateTimeFormatter.ofPattern("yyyy-MM-dd")))+"}";

    }
    
    @RequestMapping(value = "/idd", method = RequestMethod.GET)
    public @ResponseBody RoomDTO roomPageDuble(@RequestParam(value="id", required=true) Integer id){
    	RoomDTO room = service.getRooms(id, null,null,null,null).get(0);
    	return room;
    }

}
