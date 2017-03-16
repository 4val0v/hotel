package ru.relex.practice.service;

import ru.relex.practice.dto.UserDTO;
import ru.relex.practice.enumeration.RoleType;

import java.util.List;

/**
 * Интерфейс получению данных по пользователям
 */
public interface UserService {

    /**
     * Сохраняет нового пользователя
     * @param login логин пользователя
     * @param password пароль
     * @param roles список ролей пользователя
     * @return идентификатор созданного пользователя
     */
    UserDTO saveUser(String login, char[] password, List<RoleType> roles);

    /**
     * Получает список пользователей в системе
     * @return
     */
    List<UserDTO> getUsers();

    /**
     * Выполняет поиск пользователя по его логину
     * @param login логин пользователя
     * @return пользователь с заданным логином или {@code null}
     */
    UserDTO findByLogin(String login);
}
