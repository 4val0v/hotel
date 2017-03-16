package ru.relex.practice.dto;

import java.time.LocalDate;

public class RoomPriceDTO {

        private int id;
        private int roomId;
        private int priceTypeId;
        private LocalDate dateBegin;
        private LocalDate dateEnd;
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
