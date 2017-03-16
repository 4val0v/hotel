package ru.relex.practice.dao;

import ru.relex.practice.model.Order;
import ru.relex.practice.model.OrderStatus;
import ru.relex.practice.model.Room;

import java.util.Date;
import java.util.List;

/**
 * DAO for order rooms
 */
public interface OrderDAO {
	/**
     * Создает заказ брони
     * @param dateCheckIn - дата заселения
     * @param dateCheckOut - дата выселения
     * @param greetingName - имя заказчика для общения
     * @param mail - почта закзчика
     * @param phone - номер телефона закзчика
     * @param countAdults - количество заселяющихся взрослых
     * @param countChildren - количество заселяющихся детей
     * @param orderStatus - статус заказа
     * @param room - ссылка на номер
     * @return идентификатор созданного заказа
     */
	Order createOrder(Date dateCheckIn,
		    Date dateCheckOut,
		    String greetingName,
		    String mail,
		    String phone,
		    Byte countAdults,
		    Byte countChildren,
		    OrderStatus orderStatus,
		    Room room);
	
	/**
     * Выполняет поиск заказов по первому не нулевому параметру
     * @param id - идентификатор заказа
     * @param dateCheckIn - дата заселения
     * @param dateCheckOut - дата выселения
     * @param greetingName - имя заказчика для общения
     * @param mail - почта закзчика
     * @param phone - номер телефона закзчика
     * @param countAdults - количество заселяющихся взрослых
     * @param countChildren - количество заселяющихся детей
     * @param orderStatus - статус заказа
     * @param room - ссылка на номер
     * @return список заказов или {@code null}
     */
	List<Order> getOrders(Long id, 
			Date dateCheckIn,
		    Date dateCheckOut,
		    String greetingName,
		    String mail,
		    String phone,
		    Byte countAdults,
		    Byte countChildren,
		    OrderStatus orderStatus,
		    Room room);

	/**
	 * find the orders for the manager
	 * @param id - identity of order
	 * @param greetingName - guest's name
	 * @param phone - guest's phone
	 * @return - list of orders or {@code null}
	 */
	List<Order> getOrders(Long id,  String phone, String greetingName);

	/**
     * Выполняет поиск заказа по первому идентификатору заказа
     * @param id - идентификатор заказа
     * @return заказ с заданным идентификатором или {@code null}
     */
	Order findOrderByID(Long id);
	
	/**
     * Выполняет поиск заказа по дате заселения
     * @param dateCheckIn - дата заселения
     * @return список заказов с указанной датой
     */
	List<Order> findOrderByDateCheckIn(Date dateCheckIn);
	
	/**
     * Выполняет поиск заказов по дате выселения
     * @param dateCheckOut - дата выселения
     * @return список заказов с указанной датой
     */
	List<Order> findOrderByDateCheckOut(Date dateCheckOut);
	
	/**
     * Выполняет поиск заказов по имени заказчика
     * @param guestName - имя заказчика для общения
     * @return список заказов с указанным именем заказчика
     */
    List<Order> findOrderByGreetingName(String guestName);
    
    /**
     * Выполняет поиск заказов по статусу заказа
     * @param orderStatus - статус заказа
     * @return список заказов с указанным статусом
     */
	List<Order> findOrderByOrderStatus(OrderStatus orderStatus);
	
	/**
     * Выполняет поиск заказов по заказанному номеру
     * @param room - ссылка на номер
     * @return список заказов с указанным номером
     */
	List<Order> findOrderByRoom(Room room);

	/**
     * Выполняет поиск записей о бронировании по дате
     * @param dateBegin - дата с которой будет идти поиск
     * @param dateEnd - дата до которой будет идти поиск
     * @return список записей о бронировании попадающих в заданный промежуток времени
     */
	List<Order> findOrderByTime(Date dateBegin, Date dateEnd);
	
	/**
	* Выполняет поиск записей о бронировании существующих на указанный момент времени
	* @param dateTime - дата по которой будет идти поиск
	* @return список записей о бронировании существующих на указанный момент времени
	*/
	List<Order> findOrderByDay(Date dateTime);

	/**
     * Проверяет возможность забронировать номер
     * @param dateCheckIn - дата заселения
     * @param dateCheckOut - дата выселения
     * @param room - ссылка на номер
     * @return true - номер можно забронировать, false - номер нельзя забронировать
     */
	Boolean checkOrderTime(Date dateCheckIn, Date dateCheckOut, Room room);

	/**
	 * Update order
	 * @param order - current order
	 * @return updated order
	 */
	Order updateOrder(Order order);

	/**
	 * Delete order
	 * @param order - current order
	 */
	void deleteOrder(Order order);

	/**
	 * Delete order by ID
	 * @param id - order ID
	 */
	void deleteOrderById(Long id);

	/**
	 * Get all orders
	 * @return - list of orders
	 */
	List<Order> getAllOrders();

	Integer getGuestsNumberByDate(Date dateTime);

	/**
	 * Search orders by date check in or date check out
	 * and also sort their by date check out
	 * @param dateCheck - date check out or date check in
	 * @return - list of orders
	 */
	List<Order> findOrdersByDateCheckOutOrCheckIn(Date dateCheck);

}
