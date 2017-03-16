package ru.relex.practice.dto;

import java.util.Date;

import ru.relex.practice.enumeration.OrderStatusType;

/**
 *  Data Transfer Object for order
 */
public class OrderDTO {
   
    private Long id;
    private Date dateCheckIn;
    private Date dateCheckOut;
    private String greetingName;
    private String mail;
    private String phone;
    private Byte countAdults;
    private Byte countChildren;
    private OrderStatusType statusType;
    private RoomDTO roomDto;

    public OrderDTO() {
    }

    public OrderDTO(Long id) {
        this.id = id;
    }

    public Long getId() {
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
    
    public Byte getCountAdults() {
        return countAdults;
    }

    public void setCountAdults(byte countAdults) {
        this.countAdults = countAdults;
    }
    
    public Byte getCountChildren() {
        return countChildren;
    }

    public void setCountChildren(byte countChildren) {
        this.countChildren = countChildren;
    }

    public OrderStatusType getStatusType() {
        return statusType;
    }

    public void setStatusType(OrderStatusType statusType) {
        this.statusType = statusType;
    }

    public RoomDTO getRoomDto() {
        return roomDto;
    }

    public void setRoomDto(RoomDTO roomDto) {
        this.roomDto = roomDto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDTO orderDTO = (OrderDTO) o;
        return this.id.equals(orderDTO.getId());

    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }


    @Override
    public String toString() {
        return "OrderDTO{" +
                "id=" + id +
                ", dateCheckIn=" + dateCheckIn +
                ", dateCheckOut=" + dateCheckOut +
                ", greetingName='" + greetingName + '\'' +
                ", mail='" + mail + '\'' +
                ", phone='" + phone + '\'' +
                ", countAdults=" + countAdults +
                ", countChildren=" + countChildren +
                ", statusType=" + statusType +
                '}';
    }
}
