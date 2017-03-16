package ru.relex.practice.dao.impl;

import org.springframework.stereotype.Repository;
import ru.relex.practice.dao.OrderStatusDAO;
import ru.relex.practice.model.OrderStatus;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 *
 */
@Repository
public class OrderStatusDAOImpl implements OrderStatusDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public OrderStatus getStatusById(long id) {
        List<OrderStatus> statuses = entityManager.createQuery("FROM OrderStatus WHERE id =:id")
                .setParameter("id", id).getResultList();
        return statuses.isEmpty() ? null : statuses.get(0);
    }

    @Override
    public OrderStatus getStatusByName(String name) {
        List<OrderStatus> statuses = entityManager.createQuery("FROM OrderStatus WHERE name = :statusName")
                .setParameter("statusName", name).getResultList();
        return statuses.isEmpty() ? null : statuses.get(0);
    }
}
