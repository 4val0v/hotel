package ru.relex.practice.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import ru.relex.practice.dto.UserDTO;
import ru.relex.practice.enumeration.RoleType;
import ru.relex.practice.model.Role;
import ru.relex.practice.model.User;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-service.xml"})
public class UserServiceTest {

    public static final Logger logger = LoggerFactory.getLogger(UserServiceTest.class);

    @Autowired
    UserService userService;

    @Test
    @Transactional
    public void saveUser() throws Exception {
        String login = "TEST LOGIN";
        char[] password = "TestPassword".toCharArray();
        String login2 = "LOGIN2";
        char[] password2 = "TestPassword".toCharArray();

        userService.saveUser(login, password, Collections.singletonList(RoleType.ADMIN));
        userService.saveUser(login2, password2, Collections.singletonList(RoleType.USER));
        userService.saveUser("everything", "everything".toCharArray(), Arrays.asList(RoleType.ADMIN, RoleType.USER));

        for (UserDTO user : userService.getUsers()) {
            logger.info("[{}] Username: [{}], Roles: [{}]", user.getId(), user.getLogin(), user.getRoles()
                    .stream().map(RoleType::name).collect(Collectors.toList()));
        }
    }

    @Test
    public void checkUserExists() throws Exception {
        assert userService.findByLogin("admin") != null;
        assert userService.findByLogin("AdMin") != null;
        assert userService.findByLogin("Админ") == null;
    }
}