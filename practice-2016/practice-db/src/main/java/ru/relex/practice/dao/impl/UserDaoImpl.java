package ru.relex.practice.dao.impl;

import org.springframework.stereotype.Repository;
import ru.relex.practice.dao.UserDao;
import ru.relex.practice.model.Role;
import ru.relex.practice.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Set;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public User createUser(String login, String password, Set<Role> roles) {
        User user = new User();
        user.setPasswordAndSalt(password);
        user.setUsername(login);
        user.setRoles(roles);
        manager.persist(user);
        return user;
    }

    @Override
    public List<User> getUsers() {
        return manager.createQuery("FROM User", User.class).getResultList();
    }

    @Override
    public User findUserByLogin(String login) {
        List<User> users = manager.createQuery("FROM User WHERE UPPER(username) = UPPER(:login)", User.class).
                setParameter("login", login).getResultList();
        return users.isEmpty() ? null : users.get(0);
    }
}
