package ru.relex.practice.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.relex.practice.dao.OrderDAO;
import ru.relex.practice.model.Order;
import ru.relex.practice.model.OrderStatus;
import ru.relex.practice.model.Room;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

@Repository
public class OrderDAOImpl implements OrderDAO {

    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public Order createOrder(Date dateCheckIn,
		    Date dateCheckOut,
		    String greetingName,
		    String mail,
		    String phone,
		    Byte countAdults,
		    Byte countChildren,
		    OrderStatus orderStatus,
		    Room room) {
    	Order order = new Order();
    	order.setDateCheckIn(dateCheckIn);
    	order.setDateCheckOut(dateCheckOut);
    	order.setGreetingName(greetingName);
    	order.setMail(mail);
    	order.setPhone(phone);
    	order.setCountAdults(countAdults);
    	order.setCountChildren(countChildren);
    	order.setOrderStatus(orderStatus);
    	order.setRoom(room);
    	entityManager.persist(order);
        return order;
    }
    
    @Override
    public List<Order> getOrders(Long id, 
			Date dateCheckIn,
		    Date dateCheckOut,
		    String greetingName,
		    String mail,
		    String phone,
		    Byte countAdults,
		    Byte countChildren,
		    OrderStatus orderStatus,
		    Room room){
    	if (id != null){
    		return entityManager.createQuery("FROM Order WHERE id = :idOrder", Order.class)
                    .setParameter("idOrder", id).getResultList();
        }
    	if (dateCheckIn != null){
            return entityManager.createQuery("FROM Order WHERE dateCheckIn = :dCheckIn", Order.class)
                    .setParameter("dCheckIn", dateCheckIn).getResultList();
        }
    	if (dateCheckOut != null){
            return entityManager.createQuery("FROM Order WHERE dateCheckOut = :dCheckOut", Order.class)
                    .setParameter("dCheckOut", dateCheckOut).getResultList();
        }
    	if (greetingName != null){
            return entityManager.createQuery("FROM Order WHERE greetingName = :gName", Order.class)
                    .setParameter("gName", greetingName).getResultList();
        }
    	if (mail != null){
            return entityManager.createQuery("FROM Order WHERE mail = :mailOrder", Order.class)
                    .setParameter("mailOrder", mail).getResultList();
        }
    	if (phone != null){
            return entityManager.createQuery("FROM Order WHERE phone = :phoneOrder", Order.class)
                    .setParameter("phoneOrder", phone).getResultList();
        }
    	if (countAdults != null){
            return entityManager.createQuery("FROM Order WHERE countAdults = :cAdults", Order.class)
                    .setParameter("cAdults", countAdults).getResultList();
        }
    	if (countChildren != null){
            return entityManager.createQuery("FROM Order WHERE countChildren = :cChildren", Order.class)
                    .setParameter("cChildren", countChildren).getResultList();
        }
    	if (orderStatus != null){
            return entityManager.createQuery("FROM Order WHERE orderStatus = :oStatus", Order.class)
                    .setParameter("oStatus", orderStatus).getResultList();
        }
    	if (room != null){
            return entityManager.createQuery("FROM Order WHERE room = :roomOrder", Order.class)
                    .setParameter("roomOrder", room).getResultList();
        }
        return null;
    }

    @Override
    public List<Order> getOrders(Long id,  String phone, String greetingName) {
        if (id != null) {
            return entityManager.createQuery("FROM Order WHERE id = :idOrder", Order.class)
                    .setParameter("idOrder", id).getResultList();
        }
        if (!phone.isEmpty()) {
            return entityManager.createQuery("FROM Order WHERE phone = :phoneOrder", Order.class)
                    .setParameter("phoneOrder", phone).getResultList();
        }
        if (!greetingName.isEmpty()){
            String guestName = greetingName.toLowerCase();
            return entityManager.createQuery("FROM Order WHERE lower(greetingName) =:gName", Order.class)
                    .setParameter("gName", guestName).getResultList();
        }
        return null;
    }

    @Override
    public Order findOrderByID(Long id) {
        List<Order> orders = entityManager.createQuery("FROM Order WHERE id =:idOrder", Order.class)
                .setParameter("idOrder", id).getResultList();
        return orders.isEmpty() ? null : orders.get(0);
    }
    
	@Override
    public List<Order> findOrderByDateCheckIn(Date dateCheckIn) {
        List<Order> orders = entityManager.createQuery("FROM Order WHERE dateCheckIn =:dCheckIn", Order.class)
                .setParameter("dCheckIn", dateCheckIn).getResultList();
        return orders;
    }
	
	@Override
    public List<Order> findOrderByDateCheckOut(Date dateCheckOut) {
        List<Order> orders = entityManager.createQuery("FROM Order orders WHERE orders.dateCheckOut =:dCheckOut", Order.class)
                .setParameter("dCheckOut", dateCheckOut).getResultList();
        return orders;
    }
	    
    @Override
    public List<Order> findOrderByGreetingName(String greetingName) {
        List<Order> orders = entityManager.createQuery("FROM Order WHERE greetingName = :gName", Order.class)
                .setParameter("gName", greetingName).getResultList();
        return orders;
    }
    
    @Override
    public List<Order> findOrderByOrderStatus(OrderStatus orderStatus) {
        List<Order> orders = entityManager.createQuery("FROM Order WHERE orderStatus = :oStatus", Order.class)
                .setParameter("oStatus", orderStatus).getResultList();
        return orders;
    }
    
	@Override
    public List<Order> findOrderByRoom(Room room) {
        List<Order> orders = entityManager.createQuery("FROM Order WHERE room = :roomOrder", Order.class)
                .setParameter("roomOrder", room).getResultList();
        return orders;
    }
	
	@Override
    public List<Order> findOrderByTime(Date dateBegin, Date dateEnd) {
		List<Order> orders = entityManager.createQuery("FROM Order WHERE NOT (dateCheckOut <= :dBegin or dateCheckIn >= :dEnd)", Order.class)
                .setParameter("dBegin", dateBegin).setParameter("dEnd", dateEnd).getResultList();
		return orders;
	}
	
	@Override
    public List<Order> findOrderByDay(Date dateTime) {
		List<Order> orders = entityManager.createQuery("FROM Order WHERE dateCheckOut >= :dTime AND dateCheckIn <= :dTime", Order.class)
                .setParameter("dTime", dateTime).getResultList();
		return orders;
	}
	
	@Override
    public Boolean checkOrderTime(Date dateCheckIn, Date dateCheckOut, Room room){
		List<Order> orders = entityManager.createQuery("FROM Order WHERE (room = :roomOrder AND ( NOT (dateCheckOut <= :dCheckIn or dateCheckIn >= :dCheckOut)))", Order.class)
                .setParameter("roomOrder", room).setParameter("dCheckIn", dateCheckIn).setParameter("dCheckOut", dateCheckOut).getResultList();
		return orders.isEmpty();
	}
	

    @Override
    public Order updateOrder(Order order) {
        entityManager.merge(order);
        return order;
    }

    @Override
    public void deleteOrder(Order order) {
        entityManager.remove(entityManager.merge(order));
    }

    @Override
    public void deleteOrderById(Long id) {
        Order order = entityManager.find(Order.class, id);
        entityManager.remove(order);
    }

    @Override
    public List<Order> getAllOrders() {

        return entityManager.createQuery("FROM Order", Order.class).getResultList();
    }

    @Override
    public Integer getGuestsNumberByDate(Date dateTime) {
        Integer guestsNumber = 0;
        List<Order> orders = entityManager.createQuery("FROM Order WHERE dateCheckOut >= :dTime AND dateCheckIn <= :dTime", Order.class)
                .setParameter("dTime", dateTime).getResultList();
        for(Order order: orders){
            guestsNumber+=order.getCountAdults()+order.getCountChildren();
        }
        return guestsNumber;
    }

    @Override
    public List<Order> findOrdersByDateCheckOutOrCheckIn(Date dateCheck) {
        List<Order> orders = entityManager.createQuery("FROM Order WHERE dateCheckOut =:date OR dateCheckIn =:date " +
                "ORDER BY dateCheckOut", Order.class).setParameter("date", dateCheck).getResultList();
        return orders;
    }


}
