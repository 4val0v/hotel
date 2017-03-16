package ru.relex.practice.service;

import ru.relex.practice.dto.OrderDTO;
import ru.relex.practice.dto.RoomDTO;
import ru.relex.practice.enumeration.OrderStatusType;
import java.util.Date;

import java.util.List;

/**
 *
 */
public interface OrderService {

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
	OrderDTO createOrder(Date dateCheckIn,
		    Date dateCheckOut,
		    String greetingName,
		    String mail,
		    String phone,
		    Byte countAdults,
		    Byte countChildren,
		    OrderStatusType orderStatus,
		    RoomDTO room);
	
	/**
     * Сохраняет новый заказ сериализуя объект Order из json
     * @param room - сериализованный из json объект OrderDTO
     * @return DTO созданного заказа
     */
	OrderDTO saveOrderFromJson(OrderDTO order);
	
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
	List<OrderDTO> getOrders(Long id, 
			Date dateCheckIn,
		    Date dateCheckOut,
		    String greetingName,
		    String mail,
		    String phone,
		    Byte countAdults,
		    Byte countChildren,
		    OrderStatusType orderStatus,
		    RoomDTO room);
	
	// Важно! Работает только если в базе соблюдается очередность дат.
	/**
     * Выполняет поиск записей о бронировании по дате
     * @param dateBegin - дата с которой будет идти поиск
     * @param dateEnd - дата до которой будет идти поиск
     * @return список записей о бронировании попадающих в заданный промежуток времени
     */
	List<OrderDTO> findOrderByTime(Date dateBegin, Date dateEnd);
	
	// Важно! Работает только если в базе соблюдается очередность дат.
	/**
	* Выполняет поиск записей о бронировании существующих на указанный момент времени
	* @param dateBegin - дата по которой будет идти поиск
	* @return список записей о бронировании существующих на указанный момент времени
	*/
	List<OrderDTO> findOrderByDay(Date dateTime);
		
	// Важно! Работает только если в базе соблюдается очередность дат.
	/**
     * Проверяет возможность забронировать номер
     * @param dateCheckIn - дата заселения
     * @param dateCheckOut - дата выселения
     * @param room - ссылка на номер
     * @return true - номер можно забронировать, false - номер нельзя забронировать 
     */
	Boolean checkOrderTime(Date dateCheckIn, Date dateCheckOut, RoomDTO room);
	
	/**
     * Отменяет заказ бронирования
     * @param id - идентификатор заказа
     * @param dateCheckOut - текущая дата
     * @return true - заказ отменен, false - заказ не отменен 
     */
	Boolean cancellationOrder(Long id, Date datePresentTime);
	
	/**
     * Возвращает суммарную цену номера
     * @param dateCheckIn - дата заселения
     * @param dateCheckOut - дата выселения
     * @param room - ссылка на номер
	 * @return цену номера на указанный день
     */
	Long getPriseByTime(Date dateCheckIn, Date dateCheckOut, RoomDTO room);

	Integer getGuestsNumberByDate(Date dateTime);
}
