package ru.relex.practice.dao;

import ru.relex.practice.model.Role;
import ru.relex.practice.model.User;

import java.util.List;
import java.util.Set;

public interface UserDao {
    /**
     * Создаёт нового пользователя.
     * @param login логин пользователя
     * @param password пароль пользователя
     * @param roles список ролей пользователя
     * @return созданного пользователя
     */
    User createUser(String login, String password, Set<Role> roles);

    /**
     * @return пользователей присутствующих в системе
     */
    List<User> getUsers();

    /**
     * Ищет пользователя по его логину
     * @param login логин пользователя
     * @return пользователя с заданным логином или {@code null}
     */
    User findUserByLogin(String login);
}
