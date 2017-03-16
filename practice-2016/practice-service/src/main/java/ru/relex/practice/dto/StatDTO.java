package ru.relex.practice.dto;

import java.util.Date;

/**
 * DATA TRANSFER OBJECT stat
 */
public class StatDTO {

    private Long id;
    private Date workDay;
    private int adultsNumber;
    private int childrenNumber;
    private int occupiedRoomsOne;
    private int occupiedRoomsTwo;
    private int occupiedRoomsThree;
    private int occupiedRoomsFour;
    private int occupiedRoomsFive;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getWorkDay() {
        return workDay;
    }

    public void setWorkDay(Date workDay) {
        this.workDay = workDay;
    }

    public int getAdultsNumber() {
        return adultsNumber;
    }

    public void setAdultsNumber(int adultsNumber) {
        this.adultsNumber = adultsNumber;
    }

    public int getChildrenNumber() {
        return childrenNumber;
    }

    public void setChildrenNumber(int childrenNumber) {
        this.childrenNumber = childrenNumber;
    }

    public int getOccupiedRoomsOne() {
        return occupiedRoomsOne;
    }

    public void setOccupiedRoomsOne(int occupiedRoomsOne) {
        this.occupiedRoomsOne = occupiedRoomsOne;
    }

    public int getOccupiedRoomsTwo() {
        return occupiedRoomsTwo;
    }

    public void setOccupiedRoomsTwo(int occupiedRoomsTwo) {
        this.occupiedRoomsTwo = occupiedRoomsTwo;
    }

    public int getOccupiedRoomsThree() {
        return occupiedRoomsThree;
    }

    public void setOccupiedRoomsThree(int occupiedRoomsThree) {
        this.occupiedRoomsThree = occupiedRoomsThree;
    }

    public int getOccupiedRoomsFour() {
        return occupiedRoomsFour;
    }

    public void setOccupiedRoomsFour(int occupiedRoomsFour) {
        this.occupiedRoomsFour = occupiedRoomsFour;
    }

    public int getOccupiedRoomsFive() {
        return occupiedRoomsFive;
    }

    public void setOccupiedRoomsFive(int occupiedRoomsFive) {
        this.occupiedRoomsFive = occupiedRoomsFive;
    }
}
