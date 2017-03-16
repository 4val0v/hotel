package ru.relex.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.relex.practice.dto.OrderDTO;
import ru.relex.practice.service.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	OrderService service;

    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody String createOrder(@RequestBody OrderDTO order) {
    	OrderDTO orderOut = service.saveOrderFromJson(order);
    	return  "{ id: " + orderOut.getId() + " }";
    }
}
