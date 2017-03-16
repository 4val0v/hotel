package ru.relex.practice.dto;

import java.io.Serializable;
import java.util.Date;

public class RoomCommentDTO implements Serializable {
	private Long id;
	private RoomDTO roomDTO;
	private Date dateComment;
	private String firstName;
	private String secondName;
	private String email;
	private String phone;
    private double ratingPosition;
    private double ratingComfort;
    private double ratingPrice;
    private double ratingQuality;
	private String textComment;
	private boolean commentVisible;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



	public RoomDTO getRoomDTO() {
		return roomDTO;
	}



	public void setRoomDTO(RoomDTO roomDTO) {
		this.roomDTO = roomDTO;
	}



	public Date getDateComment() {
		return dateComment;
	}



	public void setDateComment(Date dateComment) {
		this.dateComment = dateComment;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getSecondName() {
		return secondName;
	}



	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public double getRatingPosition() {
		return ratingPosition;
	}



	public void setRatingPosition(double ratingPosition) {
		this.ratingPosition = ratingPosition;
	}



	public double getRatingComfort() {
		return ratingComfort;
	}



	public void setRatingComfort(double ratingComfort) {
		this.ratingComfort = ratingComfort;
	}



	public double getRatingPrice() {
		return ratingPrice;
	}



	public void setRatingPrice(double ratingPrice) {
		this.ratingPrice = ratingPrice;
	}



	public double getRatingQuality() {
		return ratingQuality;
	}



	public void setRatingQuality(double ratingQuality) {
		this.ratingQuality = ratingQuality;
	}



	public String getTextComment() {
		return textComment;
	}



	public void setTextComment(String textComment) {
		this.textComment = textComment;
	}



	public boolean isCommentVisible() {
		return commentVisible;
	}



	public void setCommentVisible(boolean commentVisible) {
		this.commentVisible = commentVisible;
	}



	@Override
	public String toString() {
		return "RoomCommentDTO{}";
	}
	
	/*@Override
	public String toString() {
		return "asd";
		/*return "RoomCommentDTO{" + "id=" + id + ", dateComment=" + dateComment + ", firstName=" + firstName
				+ ", secondName=" + secondName + ", email=" + email + ", phone=" + phone + ", ratingPosition="
				+ ratingPosition + ", ratingComfort=" + ratingComfort + ", ratingPrice=" + ratingPrice
				+ ", ratingQuality=" + ratingQuality + ", textComment=" + textComment + ", commentVisible="
				+ commentVisible +
                '}' + "\n";*/
	//}
}
