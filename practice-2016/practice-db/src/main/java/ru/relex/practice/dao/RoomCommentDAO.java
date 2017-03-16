package ru.relex.practice.dao;
import ru.relex.practice.model.RoomComment;
import ru.relex.practice.model.Room;

import java.util.List;

import javax.persistence.Query;

public interface RoomCommentDAO {
	/**
	 * Добавить новый комментарий, visible по умолчанию 0;
	 */
	RoomComment addRoomComment(Room room, String firstName, String secondName, String email,
			String phone, double ratingPosition, double ratingComfort, double ratingPrice, double ratingQuality, String textComment);

	/**
	 * получить список невидимых отзывов о комнате
	 * @param room комната
	 * @param count колличество комментариев в выборке
	 * @return список отзывов о комнате
	 */
	List<RoomComment> getRoomCommentsUnvisible(Room room, int pageNumber, int pageSize);
	
	/**
	 * получить список всех отзывов о комнате
	 * @param room комната
	 * @param count колличество комментариев в выборке
	 * @return список отзывов о комнате
	 */
	List<RoomComment> getRoomComments(Room room, int pageNumber, int pageSize);
	
	List<RoomComment> getAllRoomComments();
	
	/**
	 * получить список видимых отзывов о комнате
	 * @param room комната
	 * @param count колличество комментариев в выборке
	 * @return список отзывов о комнате
	 */
	List<RoomComment> getRoomCommentsVisible(Room room, int pageNumber, int pageSize);
	
	void refreshRoomRatingAll(Room room);
	
	/**
	 * изменить видимость комментария
	 * @param room комната
	 * @param count колличество комментариев в выборке
	 * @return список отзывов о комнате
	 */
	RoomComment changeRoomCommentVisible(RoomComment roomComment, boolean commentVisible);

	/**
	 * удалить комментарий
	 */
	void removeRoomComment(RoomComment roomComment);
	
	/**
	 * удалить комментарии о комнате
	 * @param room комната
	 */
	void removeAllRoomComments(Room room);
}
