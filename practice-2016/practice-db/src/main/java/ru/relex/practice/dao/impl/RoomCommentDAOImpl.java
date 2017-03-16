package ru.relex.practice.dao.impl;

import org.springframework.stereotype.Repository;

import ru.relex.practice.dao.RoomCommentDAO;
import ru.relex.practice.model.Room;
import ru.relex.practice.model.RoomComment;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import java.util.Date;
import java.util.List;

@Repository
public class RoomCommentDAOImpl implements RoomCommentDAO{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public RoomComment addRoomComment(Room room, String firstName, String secondName, String email, String phone,
			double ratingPosition, double ratingComfort, double ratingPrice, double ratingQuality, String textComment) {
		RoomComment room_comment = new RoomComment();
		room_comment.setRoom(room);
		room_comment.setDateComment(new Date());
		room_comment.setFirstName(firstName);
		room_comment.setSecondName(secondName);
		room_comment.setEmail(email);
		room_comment.setPhone(phone);
		room_comment.setRatingPosition(ratingPosition);
		room_comment.setRatingComfort(ratingComfort);
		room_comment.setRatingPrice(ratingPrice);
		room_comment.setRatingQuality(ratingQuality);
		room_comment.setTextComment(textComment);
		room_comment.setCommentVisible(false);
		entityManager.persist(room_comment);
		
		return room_comment;
	}

	@Override
	public List<RoomComment> getRoomCommentsUnvisible(Room room, int pageNumber, int pageSize) {
		Query query = entityManager.createQuery("FROM RoomComment WHERE commentVisible = false");
		query.setFirstResult((pageNumber-1) * pageSize); 
		query.setMaxResults(pageSize);
		List <RoomComment> roomCommentList = query.getResultList();

		return roomCommentList;
	}

	@Override
	public List<RoomComment> getRoomComments(Room room, int pageNumber, int pageSize) {
		Query query = entityManager.createQuery("FROM RoomComment", RoomComment.class);
		query.setFirstResult((pageNumber-1) * pageSize); 
		query.setMaxResults(pageSize);
		List <RoomComment> roomCommentList = query.getResultList();
		return roomCommentList;
	}

	@Override//исправить, выбирает не по комнате
	public List<RoomComment> getRoomCommentsVisible(Room room, int pageNumber, int pageSize) {
		Query query = entityManager.createQuery("FROM RoomComment WHERE commentVisible = true AND room = :roomSearch");
		query.setParameter("roomSearch", room);
		query.setFirstResult((pageNumber-1) * pageSize); 
		query.setMaxResults(pageSize);
		List <RoomComment> roomCommentList = query.getResultList();

		return roomCommentList;
	}
	
	@Override
	public List<RoomComment> getAllRoomComments() {
		/*Query query = entityManager.createQuery("FROM RoomComment");
		query.setFirstResult((pageNumber-1) * pageSize); 
		query.setMaxResults(pageSize);
		List <RoomComment> roomCommentList = query.getResultList();
	
		return roomCommentList;*/
		return entityManager.createQuery("FROM RoomComment", RoomComment.class).getResultList();
	}

	@Override
	public RoomComment changeRoomCommentVisible(RoomComment roomComment, boolean commentVisible) {
		roomComment.setCommentVisible(commentVisible);
		entityManager.merge(roomComment);
		return roomComment;
	}

	@Override
	public void refreshRoomRatingAll(Room room){
		double ratingPosition = ((Double) entityManager.createQuery("SELECT AVG(ratingPosition) FROM RoomComment WHERE room = :room").setParameter("room", room).getResultList().get(0)).doubleValue();
		double ratingComfort = ((Double) entityManager.createQuery("SELECT AVG(ratingComfort) FROM RoomComment WHERE room = :room").setParameter("room", room).getResultList().get(0)).doubleValue();
		double ratingPrice = ((Double) entityManager.createQuery("SELECT AVG(ratingPrice) FROM RoomComment WHERE room = :room").setParameter("room", room).getResultList().get(0)).doubleValue();
		double ratingQuality = ((Double) entityManager.createQuery("SELECT AVG(ratingQuality) FROM RoomComment WHERE room = :room").setParameter("room", room).getResultList().get(0)).doubleValue();
		
		room.setRatingPosition(ratingPosition);
		room.setRatingComfort(ratingComfort);
		room.setRatingPrice(ratingPrice);
		room.setRatingQuality(ratingQuality);
		
		room.setRatingAvg((ratingPosition + ratingComfort + ratingPrice + ratingQuality)/4);
		
		entityManager.merge(room);
	}

	@Override
	public void removeRoomComment(RoomComment roomComment) {
		Query query = entityManager.createQuery("DELETE FROM RoomComment AS rc WHERE rc = :roomComment");
		query.setParameter("roomComment", roomComment);
		query.executeUpdate();
	}

	@Override
	public void removeAllRoomComments(Room room) {
		Query query = entityManager.createQuery("DELETE FROM RoomComment AS rc WHERE rc.room = :room");
		query.setParameter("room", room);
		query.executeUpdate();
	}
}
