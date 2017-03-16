package ru.relex.practice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.relex.practice.dao.OrderDAO;
import ru.relex.practice.dao.RoomPriceDao;
import ru.relex.practice.dto.RoomPriceDTO;
import ru.relex.practice.dto.OrderDTO;
import ru.relex.practice.dto.RoomDTO;
import ru.relex.practice.enumeration.OrderStatusType;
import ru.relex.practice.mappings.OrderMapper;
import ru.relex.practice.mappings.OrderStatusMapper;
import ru.relex.practice.mappings.RoomMapper;
import ru.relex.practice.mappings.RoomPricesMapper;
import ru.relex.practice.model.Order;
import ru.relex.practice.model.OrderStatus;
import ru.relex.practice.model.Room;
import ru.relex.practice.service.OrderService;
import ru.relex.practice.util.DateIterator;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;


/**
 *
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDAO orderDAO;
    
    @Autowired
    RoomPricesMapper priceMapper;
    
    @Autowired
    RoomPriceDao priceDao;
    
    @Autowired
    OrderStatusMapper statusMapper;

    @Autowired
    OrderMapper orderMapper;
    
    @Autowired
    RoomMapper roomMapper;

    @Transactional
    @Override
    public OrderDTO createOrder(Date dateCheckIn,
		    Date dateCheckOut,
		    String greetingName,
		    String mail,
		    String phone,
		    Byte countAdults,
		    Byte countChildren,
		    OrderStatusType orderStatusType,
		    RoomDTO roomDTO) {
    	
    	if (dateCheckIn.before(dateCheckOut))
    	{
    		OrderStatus orderStatus = statusMapper.typeToOrderStatus(orderStatusType);
    		Room room = roomMapper.roomDtoToRoom(roomDTO);
    		Order order = orderDAO.createOrder(dateCheckIn,
    				dateCheckOut,
    				greetingName,
    				mail,
    				phone,
    				countAdults,
    				countChildren,
    				orderStatus,
    				room);
    		return orderMapper.orderToDto(order);
    	}
    	return null;
    }
    
    @Transactional
    @Override
    public OrderDTO saveOrderFromJson(OrderDTO orderDTO) {
    	OrderStatus orderStatus = statusMapper.typeToOrderStatus(orderDTO.getStatusType());
    	Room room = roomMapper.roomDtoToRoom(orderDTO.getRoomDto());
    	Order order = orderDAO.createOrder(orderDTO.getDateCheckIn(),
    			orderDTO.getDateCheckOut(),
    			orderDTO.getGreetingName(),
    			orderDTO.getMail(),
    			orderDTO.getPhone(),
    			orderDTO.getCountAdults(),
    			orderDTO.getCountChildren(),
    			orderStatus,
    			room);
    	return orderMapper.orderToDto(order);
    }
    
    @Transactional
    @Override
    public List<OrderDTO> getOrders(Long id, 
			Date dateCheckIn,
		    Date dateCheckOut,
		    String greetingName,
		    String mail,
		    String phone,
		    Byte countAdults,
		    Byte countChildren,
		    OrderStatusType orderStatusType,
		    RoomDTO roomDTO) {
    	
    	OrderStatus orderStatus;
    	if (orderStatusType != null){
    		orderStatus = statusMapper.typeToOrderStatus(orderStatusType);
		}
    	else{ orderStatus = null;}
		Room room = roomMapper.roomDtoToRoom(roomDTO);
		List<Order> orders = orderDAO.getOrders(id, dateCheckIn, dateCheckOut, greetingName, 
				mail, phone, countAdults, countChildren, orderStatus, room);
		return orderMapper.ordersToDtos(orders);
    }
    
    @Override
    public List<OrderDTO> findOrderByDay(Date dateTime){
    	List<Order> orders = orderDAO.findOrderByDay(dateTime);
    	return orderMapper.ordersToDtos(orders);
    }
    
    @Override
    public List<OrderDTO> findOrderByTime(Date dateBegin, Date dateEnd){
    	List<Order> orders = orderDAO.findOrderByTime(dateBegin, dateEnd);
    	return orderMapper.ordersToDtos(orders);
    }
    
    @Override
    public Boolean checkOrderTime(Date dateCheckIn, Date dateCheckOut, RoomDTO roomDTO){
		Room room = roomMapper.roomDtoToRoom(roomDTO);
		return orderDAO.checkOrderTime(dateCheckIn, dateCheckOut, room);
		
	}
    
    @Override
    @Transactional
    public Boolean cancellationOrder(Long id, Date datePresentTime){
    	Order order = orderDAO.findOrderByID(id);
    	if (datePresentTime.before(order.getDateCheckIn()))
    	{
            orderDAO.deleteOrder(order);
    		return true;
    	}
    	return false;
	}
    
    @Override
    public Long getPriseByTime(Date dateCheckIn, Date dateCheckOut, RoomDTO roomDTO){
    	Room room = roomMapper.roomDtoToRoom(roomDTO);
    	DateIterator dateIterator = new DateIterator();
    	List<Date> listdates = dateIterator.iterateDate(dateCheckIn, dateCheckOut);
    	List<RoomPriceDTO> prices = priceMapper.roomsPricesToRoomPriceDtos(priceDao.getCoast(room.getId()));
    	Long prise = new Long(0);
    	for (Date date : listdates) {
    		Long tmpPrise = roomDTO.getPrice();
    		LocalDate lDate = new java.sql.Date(date.getTime()).toLocalDate();
    		for (RoomPriceDTO roomPriceDTO : prices){
    			if (roomPriceDTO.getDateBegin().toEpochDay() <= lDate.toEpochDay() &&
                        roomPriceDTO.getDateEnd().toEpochDay() >= lDate.toEpochDay()){
    				tmpPrise = new Long(roomPriceDTO.getPrice());
    			}
    		}
    		prise += tmpPrise;
        }
		return prise;
	}

	@Override
	public Integer getGuestsNumberByDate(Date dateTime){
		Integer guestsNumbers = orderDAO.getGuestsNumberByDate(dateTime);
		return guestsNumbers;
	}
}
