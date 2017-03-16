package ru.relex.practice.dao.impl;

import org.springframework.stereotype.Repository;
import ru.relex.practice.dao.RoleDao;
import ru.relex.practice.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Role getRole(long id) {
        List<Role> results = entityManager.createQuery("FROM Role WHERE id = :id", Role.class).setParameter("id", id).getResultList();
        return results.isEmpty() ? null : results.get(0);
    }

    @Override
    public Role getRole(String name) {
        List<Role> results = entityManager.createQuery("FROM Role WHERE name = :name", Role.class).setParameter("name", name).getResultList();
        return results.isEmpty() ? null : results.get(0);
    }
}
