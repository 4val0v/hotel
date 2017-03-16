package ru.relex.practice.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import ru.relex.practice.dto.UserDTO;

import java.util.Collection;

/**
 * Расширение пользователя под тестовое приложение.
 */
public class PracticeUser extends User {

    private UserDTO userFromDb;

    public PracticeUser(UserDTO user, Collection<? extends GrantedAuthority> authorities) {
        super(user.getLogin(), user.getPassword(), !user.isLocked(), true, true, true, authorities);
        this.userFromDb = user;
    }

    public UserDTO getCurrentUser() {
        return userFromDb;
    }
}
