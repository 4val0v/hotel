package ru.relex.practice.service;

import ru.relex.practice.dto.OrderDTO;
import ru.relex.practice.enumeration.OrderStatusType;
import ru.relex.practice.model.Order;

import java.text.ParseException;
import java.util.List;

/**
 *  Service for manager of orders
 */
public interface OrderManagerService {

    List<OrderDTO> findOrderByStatus(OrderStatusType statusType);

    /**
     *  Update current order
     *  @param orderDTO order
     *  @return updated order
     */
    OrderDTO updateOrderDTO(OrderDTO orderDTO);

    /**
     *  Delete current order
     *  @param id - order ID
     */
    void deleteOrderDTO(Long id);

    /**
     *  Method for Search form
     *  @param orderNumber - number of booked
     *  @param  phone - guests phone
     *  @param guestName - guest name
     *  @return list of orders for manager
     */
    List<OrderDTO> findOrderDTO(Long orderNumber, String phone, String guestName);

    /**
     * Method, which changing field "isBooked" object "Room"
     * The method run everyday at 12 p.m.
     */
    void automaticChangeBookingStatus() throws ParseException;

    /**
     * Get all orders
     * @return list of all arders
     */
    List<OrderDTO> getAllOrdersDTO();
}
