package ru.relex.practice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.relex.practice.dao.OrderDAO;
import ru.relex.practice.dao.OrderStatusDAO;
import ru.relex.practice.dto.OrderDTO;
import ru.relex.practice.enumeration.OrderStatusType;
import ru.relex.practice.mappings.OrderMapper;
import ru.relex.practice.mappings.OrderStatusMapper;
import ru.relex.practice.model.Order;
import ru.relex.practice.model.OrderStatus;
import ru.relex.practice.service.OrderManagerService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *  Service for manager of orders
 */
@Service("orderManagerService")
@EnableScheduling
public class OrderManagerServiceImpl implements OrderManagerService {

    @Autowired
    OrderDAO orderDAO;

    @Autowired
    OrderStatusMapper statusMapper;

    @Autowired
    OrderMapper orderMapper;

    @Override
    public List<OrderDTO> findOrderByStatus(OrderStatusType statusType) {
        List<Order> order = orderDAO.findOrderByOrderStatus(statusMapper.typeToOrderStatus(statusType));
        return orderMapper.ordersToDtos(order);
    }

    @Override
    @Transactional
    public OrderDTO updateOrderDTO(OrderDTO orderDTO) {
        Order order = orderMapper.orderDtoToOrder(orderDTO);
        return orderMapper.orderToDto(orderDAO.updateOrder(order));
    }

    @Override
    @Transactional
    public void deleteOrderDTO(Long id) {
        orderDAO.deleteOrderById(id);
     }

    @Override
    public List<OrderDTO> findOrderDTO(Long orderNumber, String phone, String guestName) {
        List<Order> orders = orderDAO.getOrders(orderNumber, phone, guestName);
        return orderMapper.ordersToDtos(orders);
    }


    @Override
    @Transactional
    @Scheduled(cron = "0 0 12 * * *")
    public void automaticChangeBookingStatus() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date todayDate =  sdf.parse(sdf.format(new Date()));
        List<Order> orders = orderDAO.findOrdersByDateCheckOutOrCheckIn(todayDate);
        OrderStatus closedStatus = statusMapper.typeToOrderStatus(OrderStatusType.CLOSED);
        OrderStatus orderedStatus = statusMapper.typeToOrderStatus(OrderStatusType.ORDERED);
        for (Order order : orders) {
            if (order.getOrderStatus() == orderedStatus) {
                if (order.getDateCheckOut().equals(todayDate)) {
                    order.setOrderStatus(closedStatus);
                    order.getRoom().setBooked(false);
                }
                else {
                    order.getRoom().setBooked(true);
                }
                orderDAO.updateOrder(order);
            }
        }
    }

    @Override
    public List<OrderDTO> getAllOrdersDTO() {
        List<Order> orders = orderDAO.getAllOrders();
        List<OrderDTO> orderDTOs = orderMapper.ordersToDtos(orders);
            return  orderDTOs;
    }
}
