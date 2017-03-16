package ru.relex.practice.mappings;

import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import ru.relex.practice.dao.OrderStatusDAO;
import ru.relex.practice.enumeration.OrderStatusType;
import ru.relex.practice.model.OrderStatus;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
@Mapper(componentModel = "spring")
public abstract class OrderStatusMapper {

    @Autowired
    OrderStatusDAO orderStatusDAO;

    private static final Map<Long, OrderStatus> CASHED_ORDER_STATUS = new HashMap<>();

    public OrderStatusType orderStatusToType(OrderStatus status) {
        assert status != null : "Status must be set";
        return OrderStatusType.getById(status.getId());
    }

    public OrderStatus typeToOrderStatus(OrderStatusType statusType) {
        assert statusType != null : "Status must be set";
        if (!CASHED_ORDER_STATUS.containsKey(statusType.getId())) {
            CASHED_ORDER_STATUS.put(statusType.getId(), orderStatusDAO.getStatusById(statusType.getId()));
        }
        return  CASHED_ORDER_STATUS.get(statusType.getId());
    }
}
