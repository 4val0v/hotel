package ru.relex.practice.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.relex.practice.dto.UserDTO;
import ru.relex.practice.service.UserService;

import static java.util.stream.Collectors.toList;

/**
 * Сервис, который умеет возвращать данные пользователя по его имени.
 */
@Service
public class PracticeUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDTO user = userService.findByLogin(username);
        if (user == null) {
            throw new UsernameNotFoundException("User with name [" + username + "] not found");
        }

        return new PracticeUser(user, user.getRoles().stream().map(x -> new SimpleGrantedAuthority("ROLE_" + x.name())).collect(toList()));
    }
}
