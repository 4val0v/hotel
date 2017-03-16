package ru.relex.practice.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ROOMS")
public class Room {
    private int id;
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
    private String name;
    private Set<Facility> facilities = new HashSet<>();

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "SHORT_DESCRIPTION")
    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    @Basic
    @Column(name = "FULL_DESCRIPTION")
    public String getFullDescription() {
        return fullDescription;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    @Basic
    @Column(name = "PERSONS")
    public int getPersons() {
        return persons;
    }

    public void setPersons(int persons) {
        this.persons = persons;
    }

    @Basic
    @Column(name = "NUMBER_OF_ROOMS")
    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    @Basic
    @Column(name = "PRICE")
    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    @Basic
    @Column(name = "IS_BOOKED")
    public boolean getisBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    public void setisBooked(boolean booked) {
        isBooked = booked;
    }

    @Basic
    @Column(name = "IS_SHOWN")
    public boolean getisShown() {
        return isShown;
    }

    public void setShown(boolean shown) {
        isShown = shown;
    }

    public void setisShown(boolean shown) {
        isShown = shown;
    }

    @Basic
    @Column(name = "HAS_BREAKFAST")
    public boolean getHasBreakfast() {
        return hasBreakfast;
    }

    public void setHasBreakfast(boolean hasBreakfast) {
        this.hasBreakfast = hasBreakfast;
    }

    @Basic
    @Column(name = "URL_PHOTO1")
    public String getUrlPhoto1() {
        return urlPhoto1;
    }

    public void setUrlPhoto1(String urlPhoto1) {
        this.urlPhoto1 = urlPhoto1;
    }

    @Basic
    @Column(name = "URL_PHOTO2")
    public String getUrlPhoto2() {
        return urlPhoto2;
    }

    public void setUrlPhoto2(String urlPhoto2) {
        this.urlPhoto2 = urlPhoto2;
    }

    @Basic
    @Column(name = "URL_PHOTO3")
    public String getUrlPhoto3() {
        return urlPhoto3;
    }

    public void setUrlPhoto3(String urlPhoto3) {
        this.urlPhoto3 = urlPhoto3;
    }

    @Basic
    @Column(name = "RATING_POSITION")
    public double getRatingPosition() {
        return ratingPosition;
    }

    public void setRatingPosition(double ratingPosition) {
        this.ratingPosition = ratingPosition;
    }

    @Basic
    @Column(name = "RATING_COMFORT")
    public double getRatingComfort() {
        return ratingComfort;
    }

    public void setRatingComfort(double ratingComfort) {
        this.ratingComfort = ratingComfort;
    }

    @Basic
    @Column(name = "RATING_PRICE")
    public double getRatingPrice() {
        return ratingPrice;
    }

    public void setRatingPrice(double ratingPrice) {
        this.ratingPrice = ratingPrice;
    }

    @Basic
    @Column(name = "RATING_QUALITY")
    public double getRatingQuality() {
        return ratingQuality;
    }

    public void setRatingQuality(double ratingQuality) {
        this.ratingQuality = ratingQuality;
    }

    @Basic
    @Column(name = "RATING_AVG")
    public double getRatingAvg() {
        return ratingAvg;
    }

    public void setRatingAvg(double ratingAvg) {
        this.ratingAvg = ratingAvg;
    }

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "ROOM_FACILITIES", joinColumns = {@JoinColumn(name = "ROOM_ID")}, inverseJoinColumns = {@JoinColumn(name = "FACILITY_ID")})
    public Set<Facility> getFacilities() {
        return facilities;
    }

    public void setFacilities(Set<Facility> facilities) {
        this.facilities = facilities;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Transient
    public boolean isBooked() {
        return isBooked;
    }
    @Transient
    public boolean isShown() {
        return isShown;
    }
    @Transient
    public boolean isHasBreakfast() {
        return hasBreakfast;
    }
    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Room other = (Room) obj;
		if (facilities == null) {
			if (other.facilities != null)
				return false;
		} else if (!facilities.equals(other.facilities))
			return false;
		if (fullDescription == null) {
			if (other.fullDescription != null)
				return false;
		} else if (!fullDescription.equals(other.fullDescription))
			return false;
		if (hasBreakfast != other.hasBreakfast)
			return false;
		if (id != other.id)
			return false;
		if (isBooked != other.isBooked)
			return false;
		if (isShown != other.isShown)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (numberOfRooms != other.numberOfRooms)
			return false;
		if (persons != other.persons)
			return false;
		if (price != other.price)
			return false;
		if (Double.doubleToLongBits(ratingAvg) != Double.doubleToLongBits(other.ratingAvg))
			return false;
		if (Double.doubleToLongBits(ratingComfort) != Double.doubleToLongBits(other.ratingComfort))
			return false;
		if (Double.doubleToLongBits(ratingPosition) != Double.doubleToLongBits(other.ratingPosition))
			return false;
		if (Double.doubleToLongBits(ratingPrice) != Double.doubleToLongBits(other.ratingPrice))
			return false;
		if (Double.doubleToLongBits(ratingQuality) != Double.doubleToLongBits(other.ratingQuality))
			return false;
		if (shortDescription == null) {
			if (other.shortDescription != null)
				return false;
		} else if (!shortDescription.equals(other.shortDescription))
			return false;
		if (urlPhoto1 == null) {
			if (other.urlPhoto1 != null)
				return false;
		} else if (!urlPhoto1.equals(other.urlPhoto1))
			return false;
		if (urlPhoto2 == null) {
			if (other.urlPhoto2 != null)
				return false;
		} else if (!urlPhoto2.equals(other.urlPhoto2))
			return false;
		if (urlPhoto3 == null) {
			if (other.urlPhoto3 != null)
				return false;
		} else if (!urlPhoto3.equals(other.urlPhoto3))
			return false;
		return true;
	}
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((facilities == null) ? 0 : facilities.hashCode());
		result = prime * result + ((fullDescription == null) ? 0 : fullDescription.hashCode());
		result = prime * result + (hasBreakfast ? 1231 : 1237);
		result = prime * result + id;
		result = prime * result + (isBooked ? 1231 : 1237);
		result = prime * result + (isShown ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + numberOfRooms;
		result = prime * result + persons;
		result = prime * result + (int) (price ^ (price >>> 32));
		long temp;
		temp = Double.doubleToLongBits(ratingAvg);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(ratingComfort);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(ratingPosition);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(ratingPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(ratingQuality);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((shortDescription == null) ? 0 : shortDescription.hashCode());
		result = prime * result + ((urlPhoto1 == null) ? 0 : urlPhoto1.hashCode());
		result = prime * result + ((urlPhoto2 == null) ? 0 : urlPhoto2.hashCode());
		result = prime * result + ((urlPhoto3 == null) ? 0 : urlPhoto3.hashCode());
		return result;
	}
}
