package ru.relex.practice.common;

import org.springframework.context.support.GenericXmlApplicationContext;
import ru.relex.practice.dao.OrderDAO;
import ru.relex.practice.dto.OrderDTO;
import ru.relex.practice.enumeration.OrderStatusType;
import ru.relex.practice.model.Order;
import ru.relex.practice.service.OrderManagerService;
import ru.relex.practice.service.OrderService;

import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 *
 */
public class Main {
    public static void main(String[] args) throws Exception {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring-service.xml");
//        ctx.load("classpath:spring-db.xml");
        ctx.refresh();
        //OrderService orderService = ctx.getBean("orderService", OrderService.class);
        //System.out.println(orderService.findByName("Mark Okon").get(0).getOrderStatus());
        OrderManagerService managerService = ctx.getBean("orderManagerService", OrderManagerService.class);

//        List<Order> orders = managerService.findTest("Mark Okon");
        /*for (Order order: orders) {
            System.out.println(order);
            order.setGreetingName("Mark Okono");
            managerService.testUpdate(order);
        }*/
        //List<OrderDTO> orderDTOs = managerService.findOrderByStatus(OrderStatusType.HOLD);

        /*for (OrderDTO orderDTO : orderDTOs) {
            //System.out.println(orderDTO);
            orderDTO.setStatusType(OrderStatusType.ORDERED);
            managerService.updateOrderDTO(orderDTO);
        }*/

        /*for (OrderDTO orderDTO : orderDTOs) {
            //System.out.println(orderDTO);
            if (orderDTO.getGreetingName().equals("Mark Okono45656")) {
                managerService.deleteOrderDTO(orderDTO);
            }
        }*/

        //List<OrderDTO> orderDTOs = managerService.findOrderDTO(null, null, "Mark okon");
        //OrderDTO orderDTO = orderDTOs.get(0);
        //orderDTO.setGreetingName("Mark Okono");
        //orderDTO.setStatusType(OrderStatusType.ORDERED);
        //orderDTO.getRoomDto().setPersons(7);
        //managerService.updateOrderDTO(orderDTO);
        //managerService.changeStatusOrder(orderDTOs.get(0), OrderStatusType.ORDERED);
        //System.out.println(orderDTO);

        managerService.automaticChangeBookingStatus();

//        OrderDAO orderDAO = ctx.getBean("orderDAO", OrderDAO.class);
//        orderDAO.findOrdersByDateCheckOutOrCheckIn(new Date());
    }
}
