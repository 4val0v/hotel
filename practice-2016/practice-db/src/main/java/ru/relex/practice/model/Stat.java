package ru.relex.practice.model;

import javax.persistence.*;
import java.util.Date;

/**
 * 22.11.2016.
 *
 * Таблица агрегации статистики нагрузки номеров по датам.
 */
@Entity
@Table(name = "STATS")
public class Stat {

    @Id
    @SequenceGenerator(name = "statIdSeq", sequenceName = "STATS_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "statIdSeq")
    @Column(name = "ID")
    private Long id;

    @Column(name = "WORK_DAY", columnDefinition = "DATE DEFAULT SYSDATE")
    private Date workDay;

    @Column(name = "ADULTS_NUMBER")
    private Integer adultsNumber;

    @Column(name = "CHILDREN_NUMBER")
    private Integer childrenNumber;

    @Column(name = "OCCUPIED_ROOMS_ONE")
    private Integer occupiedRoomsOne;

    @Column(name = "OCCUPIED_ROOMS_TWO")
    private Integer occupiedRoomsTwo;

    @Column(name = "OCCUPIED_ROOMS_THREE")
    private Integer occupiedRoomsThree;

    @Column(name = "OCCUPIED_ROOMS_FOUR")
    private Integer occupiedRoomsFour;

    @Column(name = "OCCUPIED_ROOMS_FIVE")
    private Integer occupiedRoomsFive;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setWorkDay(Date workDay) {
        this.workDay = workDay;
    }

    public Date getWorkDay() {
        return workDay;
    }

    public Integer getAdultsNumber() {
        return adultsNumber;
    }

    public void setAdultsNumber(int adultsNumber) {
        this.adultsNumber = adultsNumber;
    }

    public Integer getChildrenNumber() {
        return childrenNumber;
    }

    public void setChildrenNumber(int childrenNumber) {
        this.childrenNumber = childrenNumber;
    }

    public Integer getOccupiedRoomsOne() {
        return occupiedRoomsOne;
    }

    public void setOccupiedRoomsOne(int occupiedRoomsOne) {
        this.occupiedRoomsOne = occupiedRoomsOne;
    }

    public Integer getOccupiedRoomsTwo() {
        return occupiedRoomsTwo;
    }

    public void setOccupiedRoomsTwo(int occupiedRoomsTwo) {
        this.occupiedRoomsTwo = occupiedRoomsTwo;
    }

    public Integer getOccupiedRoomsThree() {
        return occupiedRoomsThree;
    }

    public void setOccupiedRoomsThree(int occupiedRoomsThree) {
        this.occupiedRoomsThree = occupiedRoomsThree;
    }

    public Integer getOccupiedRoomsFour() {
        return occupiedRoomsFour;
    }

    public void setOccupiedRoomsFour(int occupiedRoomsFour) {
        this.occupiedRoomsFour = occupiedRoomsFour;
    }

    public Integer getOccupiedRoomsFive() {
        return occupiedRoomsFive;
    }

    public void setOccupiedRoomsFive(int occupiedRoomsFive) {
        this.occupiedRoomsFive = occupiedRoomsFive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Stat stat = (Stat) o;

        if (adultsNumber != stat.adultsNumber) return false;
        if (childrenNumber != stat.childrenNumber) return false;
        if (occupiedRoomsOne != stat.occupiedRoomsOne) return false;
        if (occupiedRoomsTwo != stat.occupiedRoomsTwo) return false;
        if (occupiedRoomsThree != stat.occupiedRoomsThree) return false;
        if (occupiedRoomsFour != stat.occupiedRoomsFour) return false;
        if (occupiedRoomsFive != stat.occupiedRoomsFive) return false;
        if (!id.equals(stat.id)) return false;
        return workDay.equals(stat.workDay);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + workDay.hashCode();
        result = 31 * result + adultsNumber;
        result = 31 * result + childrenNumber;
        result = 31 * result + occupiedRoomsOne;
        result = 31 * result + occupiedRoomsTwo;
        result = 31 * result + occupiedRoomsThree;
        result = 31 * result + occupiedRoomsFour;
        result = 31 * result + occupiedRoomsFive;
        return result;
    }
}
