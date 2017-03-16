package ru.relex.practice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.relex.practice.dao.UserDao;
import ru.relex.practice.dto.UserDTO;
import ru.relex.practice.enumeration.LogCategory;
import ru.relex.practice.enumeration.RoleType;
import ru.relex.practice.mappings.RoleMapper;
import ru.relex.practice.mappings.UserMapper;
import ru.relex.practice.model.User;
import ru.relex.practice.service.LoggingService;
import ru.relex.practice.service.UserService;
import ru.relex.practice.util.SecurityUtil;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    RoleMapper roleMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    LoggingService loggingService;

    @Transactional
    @Override
    public UserDTO saveUser(String login, char[] password, List<RoleType> roles) {
        User user = userDao.createUser(login, SecurityUtil.encodePassword(password, null), roleMapper.roleTypesToRoles(roles));
        loggingService.logEventForCurrentUser(LogCategory.CREATE, user.getUsername());
        return userMapper.userToDto(user);
    }

    @Override
    public List<UserDTO> getUsers() {
        return userMapper.usersToDtos(userDao.getUsers());
    }

    @Override
    public UserDTO findByLogin(String login) {
        assert login != null;
        User user = userDao.findUserByLogin(login);
        return userMapper.userToDto(user);
    }
}
