package ru.relex.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ru.relex.practice.dto.RoomCommentDTO;
import ru.relex.practice.dto.RoomDTO;
import ru.relex.practice.model.Room;
import ru.relex.practice.service.RoomCommentService;
import ru.relex.practice.service.RoomService;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/")
public class RoomCommentController {

	int roomCommentCountOnPage = 5;

	@Autowired
	RoomService service;

	@Autowired
	RoomCommentService roomCommentService;

	//id и page нужны для этой фигни
	@RequestMapping(value = "roomcomments", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<RoomCommentDTO> roomCommentPage(@RequestParam(value = "id") Integer id, @RequestParam(value = "page") Integer page) {
		RoomDTO roomDTO = service.getRooms(id, null, null, null, null).get(0);
		return roomCommentService.getRoomCommentsVisible(roomDTO, page, roomCommentCountOnPage);
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody String roomCommentAdd(@RequestBody RoomCommentDTO roomCommentDTO) {
		RoomCommentDTO roomCommentOut = roomCommentService.saveRoomCommentFromJson(roomCommentDTO);
		return "asd";
	}
}