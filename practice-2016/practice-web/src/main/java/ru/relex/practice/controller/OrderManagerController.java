package ru.relex.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.relex.practice.dto.OrderDTO;
import ru.relex.practice.enumeration.OrderStatusType;
import ru.relex.practice.service.OrderManagerService;


import java.util.List;

@Controller
@RequestMapping("/ordermanager")
public class OrderManagerController {

    @Autowired
    OrderManagerService managerService;

    /**
     * Method get orders, which is waited confirmation
     * @param random - service param for small hack - a browser
     * will not cache the data (random = new Date().getTime() in JS)
     * @return - list of orders
     */
    @RequestMapping(value = "/getOrdersByStatus", method = RequestMethod.GET)
    @ResponseBody
    public List<OrderDTO> getOrdersByStatus(@RequestParam String random) {
        List<OrderDTO> orderDTOs = managerService.findOrderByStatus(OrderStatusType.HOLD);
        return orderDTOs;
    }

    /**
     * Method which return all orders or orders in search criteria(params)
     * @param id - order id
     * @param phone - guest's phone
     * @param name - guest's name
     * @return - list of orders
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public List<OrderDTO> findOrders(@RequestParam(required = false) Long id,
                                     @RequestParam(required = false) String phone,
                                     @RequestParam(required = false) String name) {
        List<OrderDTO> orders;
        if (id == null && phone == null && name == null) {
            orders = managerService.getAllOrdersDTO();
        }
        else {
            orders = managerService.findOrderDTO(id, phone, name);
        }
        return orders;
    }

    /**
     * Method delete order
     * @param id - order ID
     * @return - string
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteOrder(@PathVariable Long id) {
        managerService.deleteOrderDTO(id);
        return "Order " + id + " was deleted";
    }

    /**
     * Method update order
     * @param orderDTO - order
     * @return - updated order
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    @ResponseBody
    public OrderDTO updateOrder(@RequestBody OrderDTO orderDTO) {
        return managerService.updateOrderDTO(orderDTO);
    }
}
