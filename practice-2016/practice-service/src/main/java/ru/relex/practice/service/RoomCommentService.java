package ru.relex.practice.service;

import java.util.*;

import ru.relex.practice.dto.RoomCommentDTO;
import ru.relex.practice.dto.RoomDTO;
import ru.relex.practice.model.Room;
import ru.relex.practice.model.RoomComment;


public interface RoomCommentService {
	
	/**
	 * Добавить новый комментарий, visible по умолчанию 0;
	 */
	public RoomCommentDTO addRoomComment(RoomDTO roomDTO, String firstName, String secondName, String email,
			String phone, double ratingPosition, double ratingComfort, double ratingPrice, double ratingQuality, String textComment);

	public List<RoomCommentDTO> getAllRoomComments();
	
	/**
	 * получить список невидимых отзывов о комнате
	 * @param room комната
	 * @param count колличество комментариев в выборке
	 * @return список отзывов о комнате
	 */
	public List<RoomCommentDTO> getRoomCommentsUnvisible(RoomDTO roomDTO, int pageNumber, int pageSize);
	
	/**
	 * получить список всех отзывов о комнате
	 * @param room комната
	 * @param count колличество комментариев в выборке
	 * @return список отзывов о комнате
	 */
	public List<RoomCommentDTO> getRoomComments(RoomDTO roomDTO, int pageNumber, int pageSize);
	
	/**
	 * получить список видимых отзывов о комнате
	 * @param room комната
	 * @param count колличество комментариев в выборке
	 * @return список отзывов о комнате
	 */
	public List<RoomCommentDTO> getRoomCommentsVisible(RoomDTO roomDTO, int pageNumber, int pageSize);
	
	/**
	 * изменить видимость комментария
	 * @param room комната
	 * @param count колличество комментариев в выборке
	 * @return список отзывов о комнате
	 */
	public RoomCommentDTO changeRoomCommentVisible(RoomCommentDTO roomComment, boolean commentVisible);

	/**
	 * удалить комментарий
	 */
	public void removeRoomComment(RoomCommentDTO roomComment);
	
	/**
	 * пересчет рейтинга
	 */
	public void refreshRoomRatingAll(RoomDTO roomDTO);
	
	RoomCommentDTO saveRoomCommentFromJson(RoomCommentDTO roomComment);
	
	/**
	 * удалить комментарии о комнате
	 * @param room комната
	 */
	public void removeAllRoomComments(RoomDTO roomDTO);
}