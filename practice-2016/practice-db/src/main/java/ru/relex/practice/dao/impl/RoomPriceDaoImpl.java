package ru.relex.practice.dao.impl;


import org.springframework.stereotype.Repository;
import ru.relex.practice.dao.RoomPriceDao;
import ru.relex.practice.model.RoomPrice;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RoomPriceDaoImpl implements RoomPriceDao {

    @PersistenceContext
    EntityManager manager;

    @Override
    public List<RoomPrice> getCoast(Integer id) {
        return manager.createQuery("from RoomPrice " +
                "where roomId = :id", RoomPrice.class)
                .setParameter("id", id).getResultList();
    }
}
