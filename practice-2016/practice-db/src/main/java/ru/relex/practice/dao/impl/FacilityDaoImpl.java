package ru.relex.practice.dao.impl;


import org.springframework.stereotype.Repository;
import ru.relex.practice.dao.FacilityDao;
import ru.relex.practice.model.Facility;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class FacilityDaoImpl implements FacilityDao{

    @PersistenceContext
    private EntityManager manager;

    @Override
    public Facility getByID(Integer id) {
    	List<Facility> facilities = manager.createQuery("from Facility where id = :id", Facility.class).setParameter("id", id).getResultList();
        return facilities.isEmpty() ? null : facilities.get(0);
    }

    @Override
    public Facility getByName(String name) {
        return name == null ? null : manager.createQuery("from Facility where name = :name", Facility.class).setParameter("name", name).getResultList().get(0);
    }

    @Override
    public List<Facility> getFacilities() {
        return manager.createQuery("from Facility", Facility.class).getResultList();
    }
}
