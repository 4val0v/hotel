package ru.relex.practice.dao.impl;

import org.springframework.stereotype.Repository;
import ru.relex.practice.dao.EmailDao;
import ru.relex.practice.model.Email;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class EmailDaoImpl implements EmailDao {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public Email createEmail(String email) {
        Email address = new Email();
        address.setEmail(email);

        manager.persist(address);
        return address;
    }

    @Override
    public List<Email> getEmails() {
        return manager.createQuery("FROM Email", Email.class).getResultList();
    }
}