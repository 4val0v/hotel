package ru.relex.practice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.relex.practice.dao.LoggingDao;
import ru.relex.practice.dto.UserDTO;
import ru.relex.practice.enumeration.LogCategory;
import ru.relex.practice.mappings.LogMapper;
import ru.relex.practice.mappings.UserMapper;
import ru.relex.practice.model.LogType;
import ru.relex.practice.model.User;
import ru.relex.practice.service.LoggingService;
import ru.relex.practice.util.SecurityUtil;

/**
 * Сервис по логированию сообщений
 */
@Service
public class LoggingServiceImpl implements LoggingService {

    @Autowired
    LogMapper logMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    LoggingDao loggingDao;

    @Override
    @Transactional
    public void logEventForCurrentUser(LogCategory category, String message) {
        logEvent(category, SecurityUtil.getCurrentUser(), message);
    }

    @Override
    @Transactional
    public void logEvent(LogCategory category, UserDTO user, String message) {
        LogType logType = logMapper.logCategoryToType(category);
        loggingDao.logEvent(userMapper.userDtoToUser(user), logType, message);
    }

    @Override
    public void logEvent(LogCategory category, String message) {
        logEvent(category, null, message);
    }
}
