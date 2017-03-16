package ru.relex.practice.mappings;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import ru.relex.practice.dto.RoomCommentDTO;
import ru.relex.practice.model.RoomComment;


@Mapper(componentModel = "spring")
public abstract class RoomCommentMapper {

	@Autowired
    protected RoomMapper roomMapper;

    @Mapping(source = "id", target = "id")
    @Mapping(source = "dateComment", target = "dateComment")
    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "secondName", target = "secondName")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "phone", target = "phone")
    @Mapping(source = "ratingPosition", target = "ratingPosition")
    @Mapping(source = "ratingComfort", target = "ratingComfort")
    @Mapping(source = "ratingPrice", target = "ratingPrice")
    @Mapping(source = "ratingQuality", target = "ratingQuality")
    @Mapping(source = "textComment", target = "textComment")
    @Mapping(source = "commentVisible", target = "commentVisible")
    @Mapping(expression = "java(roomMapper.roomToDto(roomComment.getRoom()))", target = "roomDTO")
    public abstract RoomCommentDTO RoomCommentToDto(RoomComment roomComment);
	
    @Mapping(source = "id", target = "id")
    @Mapping(source = "dateComment", target = "dateComment")
    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "secondName", target = "secondName")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "phone", target = "phone")
    @Mapping(source = "ratingPosition", target = "ratingPosition")
    @Mapping(source = "ratingComfort", target = "ratingComfort")
    @Mapping(source = "ratingPrice", target = "ratingPrice")
    @Mapping(source = "ratingQuality", target = "ratingQuality")
    @Mapping(source = "textComment", target = "textComment")
    @Mapping(source = "commentVisible", target = "commentVisible")
    @Mapping(expression = "java(roomMapper.roomDtoToRoom(roomCommentDTO.getRoomDTO()))", target = "room")
    public abstract RoomComment DtoToRoomComment(RoomCommentDTO roomCommentDTO);
    
    public abstract List<RoomCommentDTO>RoomCommentsToDtos(Collection<RoomComment> roomComments);

    public abstract List<RoomComment> DtosToRoomComments(Collection<RoomCommentDTO> roomCommentDTOs);
}