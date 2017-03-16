package ru.relex.practice.mappings;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import ru.relex.practice.dto.OrderDTO;
import ru.relex.practice.model.Order;

import java.util.Collection;
import java.util.List;

/**
 *  Mapper for Order
 */
@Mapper(componentModel = "spring")
public abstract class OrderMapper {

    @Autowired
    protected OrderStatusMapper statusMapper;

    @Autowired
    protected RoomMapper roomMapper;

    @Mapping(source = "id", target = "id")
    @Mapping(source = "dateCheckIn", target = "dateCheckIn")
    @Mapping(source = "dateCheckOut", target = "dateCheckOut")
    @Mapping(source = "greetingName", target = "greetingName")
    @Mapping(source = "mail", target = "mail")
    @Mapping(source = "phone", target = "phone")
    @Mapping(source = "countAdults", target = "countAdults")
    @Mapping(source = "countChildren", target = "countChildren")
    @Mapping(expression = "java(statusMapper.orderStatusToType(order.getOrderStatus()))", target = "statusType")
    @Mapping(expression = "java(roomMapper.roomToDto(order.getRoom()))", target = "roomDto")
    public abstract OrderDTO orderToDto(Order order);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "dateCheckIn", target = "dateCheckIn")
    @Mapping(source = "dateCheckOut", target = "dateCheckOut")
    @Mapping(source = "greetingName", target = "greetingName")
    @Mapping(source = "mail", target = "mail")
    @Mapping(source = "phone", target = "phone")
    @Mapping(source = "countAdults", target = "countAdults")
    @Mapping(source = "countChildren", target = "countChildren")
    @Mapping(expression ="java(statusMapper.typeToOrderStatus(orderDTO.getStatusType()))", target = "orderStatus")
    @Mapping(expression = "java(roomMapper.roomDtoToRoom(orderDTO.getRoomDto()))", target = "room")
    public abstract Order orderDtoToOrder(OrderDTO orderDTO);

    public abstract List<OrderDTO> ordersToDtos(Collection<Order> orders);

    public abstract List<Order> orderDtosToOrders(Collection<OrderDTO> orderDTOs);

}
