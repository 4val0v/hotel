package ru.relex.practice.model;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "ROOM_PRICES")
public class RoomPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "ROOM_ID")
    private int roomId;

    @Column(name = "PRICE_TYPE_ID")
    private int priceTypeId;

    @Column(name = "START_DATE")
    private LocalDate dateBegin;

    @Column(name = "END_DATE")
    private LocalDate dateEnd;

    @Column(name = "PRICE")
    private int price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getPriceTypeId() {
        return priceTypeId;
    }

    public void setPriceTypeId(int priceTypeId) {
        this.priceTypeId = priceTypeId;
    }

    public LocalDate getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(LocalDate dateBegin) {
        this.dateBegin = dateBegin;
    }

    public LocalDate getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(LocalDate dateEnd) {
        this.dateEnd = dateEnd;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
