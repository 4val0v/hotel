package ru.relex.practice.service.impl;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.relex.practice.service.RoomCommentService;
import ru.relex.practice.service.RoomService;
import ru.relex.practice.dao.RoomCommentDAO;
import ru.relex.practice.dto.RoomDTO;
import ru.relex.practice.mappings.RoomCommentMapper;
import ru.relex.practice.mappings.RoomMapper;
import ru.relex.practice.model.Room;
import ru.relex.practice.model.RoomComment;
import ru.relex.practice.dto.RoomCommentDTO;;

@Service("roomCommentService")
public class RoomCommentServiceImpl implements RoomCommentService{
	
	@Autowired
	private RoomCommentDAO dao;
	
	@Autowired
    RoomCommentMapper roomCommentMapper;
	
	@Autowired
    RoomMapper roomMapper;
	
	@Transactional
	@Override
	public RoomCommentDTO addRoomComment(RoomDTO roomDTO, String firstName, String secondName, String email,
			String phone, double ratingPosition, double ratingComfort, double ratingPrice, double ratingQuality, String textComment)
	{
		return roomCommentMapper.RoomCommentToDto(dao.addRoomComment(roomMapper.roomDtoToRoom(roomDTO), firstName, secondName, email, phone, ratingPosition, ratingComfort, ratingPrice, ratingQuality, textComment));
	}

	@Transactional
    @Override
    public RoomCommentDTO saveRoomCommentFromJson(RoomCommentDTO roomCommentDTO) {
    	RoomComment room_comment = dao.addRoomComment(
    			roomMapper.roomDtoToRoom(roomCommentDTO.getRoomDTO()), 
    			roomCommentDTO.getFirstName(), 
    			roomCommentDTO.getSecondName(), 
    			roomCommentDTO.getEmail(), 
    			roomCommentDTO.getPhone(), 
    			roomCommentDTO.getRatingPosition(), 
    			roomCommentDTO.getRatingComfort(), 
    			roomCommentDTO.getRatingPrice(), 
    			roomCommentDTO.getRatingQuality(), 
    			roomCommentDTO.getTextComment());

    	return roomCommentMapper.RoomCommentToDto(room_comment);
    }
	
	@Override
	public List<RoomCommentDTO> getAllRoomComments()
	{
		return roomCommentMapper.RoomCommentsToDtos(dao.getAllRoomComments());
	}

	@Override
	public List<RoomCommentDTO> getRoomComments(RoomDTO roomDTO, int pageNumber, int pageSize) {
		return roomCommentMapper.RoomCommentsToDtos(dao.getRoomComments(roomMapper.roomDtoToRoom(roomDTO), pageNumber, pageSize));
	}

	@Override
	public List<RoomCommentDTO> getRoomCommentsVisible(RoomDTO roomDTO, int pageNumber, int pageSize) {
		return roomCommentMapper.RoomCommentsToDtos(dao.getRoomCommentsVisible(roomMapper.roomDtoToRoom(roomDTO), pageNumber, pageSize));
	}
	
	@Override
	public List<RoomCommentDTO> getRoomCommentsUnvisible(RoomDTO roomDTO, int pageNumber, int pageSize) {
		return roomCommentMapper.RoomCommentsToDtos(dao.getRoomCommentsUnvisible(roomMapper.roomDtoToRoom(roomDTO), pageNumber, pageSize));
	}

	@Transactional
	@Override
	public RoomCommentDTO changeRoomCommentVisible(RoomCommentDTO roomCommentDTO, boolean commentVisible) {
		return roomCommentMapper.RoomCommentToDto(dao.changeRoomCommentVisible(roomCommentMapper.DtoToRoomComment(roomCommentDTO), commentVisible));
	}
	
	@Transactional
	@Override
	public void refreshRoomRatingAll(RoomDTO roomDTO)
	{
		dao.refreshRoomRatingAll(roomMapper.roomDtoToRoom(roomDTO));
	}

	@Transactional
	@Override
	public void removeRoomComment(RoomCommentDTO roomCommentDTO) {
		dao.removeRoomComment(roomCommentMapper.DtoToRoomComment(roomCommentDTO));
	}

	@Transactional
	@Override
	public void removeAllRoomComments(RoomDTO roomDTO) {
		dao.removeAllRoomComments(roomMapper.roomDtoToRoom(roomDTO));
	}
}
