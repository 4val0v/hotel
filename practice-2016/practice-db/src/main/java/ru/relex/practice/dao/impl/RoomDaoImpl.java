package ru.relex.practice.dao.impl;

import org.springframework.stereotype.Repository;
import ru.relex.practice.dao.RoomDao;
import ru.relex.practice.model.Facility;
import ru.relex.practice.model.Room;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Set;

@Repository
public class RoomDaoImpl implements RoomDao {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public Room createRoom(String shortDescription, String fullDescription, Integer persons,
    		Integer numberOfRooms, Long price, Boolean isBooked, Boolean isShown,
    		Boolean hasBreakfast, String urlPhoto1, String urlPhoto2, String urlPhoto3,
    		Double ratingPosition, Double ratingComfort, Double ratingPrice, Double ratingQuality,
    		Double ratingAvg, Set<Facility> facilities, String name) {
        Room room = new Room();
        room.setShortDescription(shortDescription);
        room.setFullDescription(fullDescription);
        room.setPersons(persons);
        room.setNumberOfRooms(numberOfRooms);
        room.setPrice(price);
        room.setBooked(isBooked);
        room.setShown(isShown);
        room.setHasBreakfast(hasBreakfast);
        room.setUrlPhoto1(urlPhoto1);
        room.setUrlPhoto2(urlPhoto2);
        room.setUrlPhoto3(urlPhoto3);
        room.setRatingPosition(ratingPosition);
        room.setRatingComfort(ratingComfort);
        room.setRatingPrice(ratingPrice);
        room.setRatingQuality(ratingQuality);
        room.setRatingAvg(ratingAvg);
        room.setName(name);
        manager.persist(room);

        return room;
    }
    
    @Override
    public void deleteRoom(Integer id) {
    	Room room = manager.find(Room.class, id);
    	manager.remove(room);
    }

    @Override
    public void updateFacilitiesForRoom(Integer id, Set<Facility> facilities) {
    	Room room = manager.find(Room.class, id);
    	room.setFacilities(facilities);
    	manager.merge(room);
    }
    
    @Override
    public void updateRoom(Integer id, String shortDescription,
            String fullDescription,
            Integer persons,
            Integer numberOfRooms,
            Long price,
            Boolean isBooked,
            Boolean isShown,
            Boolean hasBreakfast,
            String urlPhoto1, String urlPhoto2, String urlPhoto3,
            Double ratingPosition, Double ratingComfort, Double ratingPrice, Double ratingQuality,
            Double ratingAvg, Set<Facility> facilities, String name) {
    	Room room = manager.find(Room.class, id);
    	/* TODO: Need to info user that id not applicable */
    	if (room == null)
    		return;
    	if (shortDescription != null)
    		room.setShortDescription(shortDescription);
    	if (fullDescription != null)
    		room.setFullDescription(fullDescription);
    	if (persons != null)
    		room.setPersons(persons);
    	if (numberOfRooms != null)
    		room.setNumberOfRooms(numberOfRooms);
    	if (price != null)
    		room.setPrice(price);
    	if (isBooked != null)
    		room.setisBooked(isBooked);
    	if (isShown != null)
    		room.setisShown(isShown);
    	if (hasBreakfast != null)
    		room.setHasBreakfast(hasBreakfast);
    	if (urlPhoto1 != null)
    		room.setUrlPhoto1(urlPhoto1);
    	if (urlPhoto2 != null)
    		room.setUrlPhoto1(urlPhoto2);
    	if (urlPhoto3 != null)
    		room.setUrlPhoto1(urlPhoto3);
    	if (ratingPosition != null)
    		room.setRatingPosition(ratingPosition);
    	if (ratingComfort != null)
    		room.setRatingComfort(ratingComfort);
    	if (ratingPrice != null)
    		room.setRatingPrice(ratingPrice);
    	if (ratingQuality != null)
    		room.setRatingQuality(ratingQuality);
    	
    	room.setRatingAvg((room.getRatingComfort() + room.getRatingPosition() +
    			room.getRatingPrice() + room.getRatingQuality())/4);
    	
    	if (facilities != null)
    		room.setFacilities(facilities);
    	if (name != null)
    		room.setName(name);
    	
    	manager.merge(room);
    }
    
    @Override
    public List<Room> getRooms(Integer id, Integer persons, Integer amountOfRooms, Integer prices, Boolean hasBreakfast) {
        if (id != null){
            System.out.println("id not null");
            return manager.createQuery("from Room where id = :id", Room.class).setParameter("id", id).getResultList();
        }
        System.out.println("id is null");
        if (persons !=null){
            return manager.createQuery("from Room where persons = :persons", Room.class).setParameter("persons", persons).getResultList();
        }
        if (amountOfRooms !=null){
            return manager.createQuery("from Room where  numberOfRooms = :param", Room.class).setParameter("param", amountOfRooms).getResultList();
        }
        if (prices !=null){
            return manager.createQuery("from Room where prices = :param", Room.class).setParameter("param", prices).getResultList();
        }
        if (hasBreakfast !=null){
            return manager.createQuery("from Room where hasBreakfast = :param", Room.class).setParameter("param", hasBreakfast).getResultList();
        }
        return null;
    }

    @Override
    public List<Room> getRooms() {
        return manager.createQuery("FROM Room", Room.class).getResultList();
    }

    @Override
    public List<Room> getTopFive() {
    //    String sqlQuery = "select * from Room order by ratingAvg desc limit 5";
    //    return manager.createNativeQuery(sqlQuery, Room.class).getResultList();
        return manager.createQuery("from Room order by ratingAvg desc", Room.class).setMaxResults(5).getResultList();
    }
}
