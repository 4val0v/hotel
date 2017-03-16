package ru.relex.practice.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ORDERS")
public class Order {

    @Id
    @SequenceGenerator(name = "orderIdSec", sequenceName = "ORDERS_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orderIdSec")
    @Column(name = "ID")
    private Long id;

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_CHECK_IN", nullable = false)
    private Date dateCheckIn;

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_CHECK_OUT", nullable = false)
    private Date dateCheckOut;

    @Basic
    @Column(name = "GREETING_NAME", nullable = false, updatable = true, length = 256)
    private String greetingName;

    @Basic
    @Column(name = "MAIL", nullable = false, updatable = false, length = 256)
    private String mail;

    @Basic
    @Column(name = "PHONE", nullable = false, updatable = true, length = 32)
    private String phone;

    @Basic
    @Column(name = "COUNT_ADULTS", nullable = false, updatable = false, length = 2)
    private byte countAdults;

    @Basic
    @Column(name = "COUNT_CHILDREN", nullable = false, updatable = false, length = 2)
    private byte countChildren;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ORDER_STATUS_ID", nullable = false)
    private OrderStatus orderStatus;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "ROOM_ID", nullable = false)
    private Room room;

    public Order() {
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateCheckIn() {
        return dateCheckIn;
    }

    public void setDateCheckIn(Date dateCheckIn) {
        this.dateCheckIn = dateCheckIn;
    }

    public Date getDateCheckOut() {
        return dateCheckOut;
    }

    public void setDateCheckOut(Date dateCheckOut) {
        this.dateCheckOut = dateCheckOut;
    }

    public String getGreetingName() {
        return greetingName;
    }

    public void setGreetingName(String greetingName) {
        this.greetingName = greetingName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public byte getCountAdults() {
        return countAdults;
    }

    public void setCountAdults(byte countAdults) {
        this.countAdults = countAdults;
    }

    public byte getCountChildren() {
        return countChildren;
    }

    public void setCountChildren(byte countChildren) {
        this.countChildren = countChildren;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return this.id.equals(order.getId());
    }

    @Override
    public int hashCode() {
        return  this.id.hashCode();
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", dateCheckIn=" + dateCheckIn +
                ", dateCheckOut=" + dateCheckOut +
                ", greetingName='" + greetingName + '\'' +
                ", mail='" + mail + '\'' +
                ", phone='" + phone + '\'' +
                ", countAdults=" + countAdults +
                ", countChildren=" + countChildren +
                '}';
    }
}
