package ru.relex.practice.dao;

import ru.relex.practice.model.OrderStatus;

import java.util.List;

/**
 *  DAO for statuses of order
 */

public interface OrderStatusDAO {

    /**
     * Return order status by status id
     * @param id - status id
     * @return - order status
     */
    OrderStatus getStatusById(long id);

    /**
     * Return order status by status name
     * @param name - status name
     * @return - order status
     */
    OrderStatus getStatusByName(String name);

}
