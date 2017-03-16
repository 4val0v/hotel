package ru.relex.practice.dto;


import ru.relex.practice.enumeration.FacilitiesEnum;

import java.io.Serializable;
import java.util.Set;

public class RoomDTO implements Serializable {
    private Integer id;
    private String shortDescription;
    private String fullDescription;
    private int persons;
    private int numberOfRooms;
    private long price;
    private boolean isBooked;
    private boolean isShown;
    private boolean hasBreakfast;
    private String urlPhoto1;
    private String urlPhoto2;
    private String urlPhoto3;
    private double ratingPosition;
    private double ratingComfort;
    private double ratingPrice;
    private double ratingQuality;
    private double ratingAvg;
    private Set<FacilitiesEnum> facilities;
    private String name;

    public void setId(Integer id) {
        this.id = id;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    public int getPersons() {
        return persons;
    }

    public void setPersons(int persons) {
        this.persons = persons;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public boolean getisBooked() {
        return isBooked;
    }

    public void setisBooked(boolean booked) {
        isBooked = booked;
    }

    public boolean getisShown() {
        return isShown;
    }

    public void setisShown(boolean shown) {
        isShown = shown;
    }

    public boolean getHasBreakfast() {
        return hasBreakfast;
    }

    public void setHasBreakfast(boolean hasBreakfast) {
        this.hasBreakfast = hasBreakfast;
    }

    public String getUrlPhoto1() {
        return urlPhoto1;
    }

    public void setUrlPhoto1(String urlPhoto1) {
        this.urlPhoto1 = urlPhoto1;
    }

    public String getUrlPhoto2() {
        return urlPhoto2;
    }

    public void setUrlPhoto2(String urlPhoto2) {
        this.urlPhoto2 = urlPhoto2;
    }

    public String getUrlPhoto3() {
        return urlPhoto3;
    }

    public void setUrlPhoto3(String urlPhoto3) {
        this.urlPhoto3 = urlPhoto3;
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

    public double getRatingAvg() {
        return ratingAvg;
    }

    public void setRatingAvg(double ratingAvg) {
        this.ratingAvg = ratingAvg;
    }

    public Set<FacilitiesEnum> getFacilities() {
        return facilities;
    }

    public void setFacilities(Set<FacilitiesEnum> facilities) {
        this.facilities = facilities;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    public boolean isShown() {
        return isShown;
    }

    public void setShown(boolean shown) {
        isShown = shown;
    }

    public boolean isHasBreakfast() {
        return hasBreakfast;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "RoomDTO{" +
                "id=" + id +
                ", shortDescription='" + shortDescription + '\'' +
                ", fullDescription='" + fullDescription + '\'' +
                ", persons=" + persons +
                ", numberOfRooms=" + numberOfRooms +
                ", price=" + price +
                ", isBooked=" + isBooked +
                ", isShown=" + isShown +
                ", hasBreakfast=" + hasBreakfast +
                ", urlPhoto1='" + urlPhoto1 + '\'' +
                ", urlPhoto2='" + urlPhoto2 + '\'' +
                ", urlPhoto3='" + urlPhoto3 + '\'' +
                ", ratingPosition=" + ratingPosition +
                ", ratingComfort=" + ratingComfort +
                ", ratingPrice=" + ratingPrice +
                ", ratingQuality=" + ratingQuality +
                ", ratingAvg=" + ratingAvg +
                ", facilities=" + facilities.isEmpty() +
                '}' + "\n";
    }
}
