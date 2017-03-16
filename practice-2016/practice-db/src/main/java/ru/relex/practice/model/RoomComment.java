package ru.relex.practice.model;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Rooms_Comments")
public class RoomComment {
	
	@Id
	@SequenceGenerator(name = "commentIdSec", sequenceName = "COMMENT_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "commentIdSec")
    @Column(name = "ID")
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "ROOM_ID", nullable = false)
	private Room room;

	@Basic
	@Column(name = "Date_Comment")
	private Date dateComment;
	
	@Basic
	@Column(name = "First_Name")
	private String firstName;
	
	@Basic
	@Column(name = "Second_Name")
	private String secondName;
	
	@Basic
	@Column(name = "Email")
	private String email;
	
	@Basic
	@Column(name = "Phone")
	private String phone;
    
	@Basic
	@Column(name = "Rating_1")
	private double ratingPosition;
	
	@Basic
	@Column(name = "Rating_2")
	private double ratingComfort;
	
	@Basic
	@Column(name = "Rating_3")
	private double ratingPrice;
	
	@Basic
	@Column(name = "Rating_4")
	private double ratingQuality;
	
	@Basic
	@Column(name = "Room_Comment")
	private String textComment;
	
	@Basic
	@Column(name = "Comment_Visible", updatable = true)
	private boolean commentVisible;
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Room getRoom() {
		return room;
	}



	public void setRoom(Room room) {
		this.room = room;
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
		return "RoomComment [id=" + id + ", dateComment=" + dateComment + ", firstName=" + firstName + ", secondName="
				+ secondName + ", email=" + email + ", phone=" + phone + ", ratingPosition=" + ratingPosition
				+ ", ratingComfort=" + ratingComfort + ", ratingPrice=" + ratingPrice + ", ratingQuality="
				+ ratingQuality + ", textComment=" + textComment + ", commentVisible=" + commentVisible + "]";
	}
	
}
