package ru.relex.practice.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import ru.relex.practice.enumeration.LogCategory;
import ru.relex.practice.service.LoggingService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Логирующий обработчик выхода из системы
 */
public class LoggingLogoutHandler implements LogoutHandler {

    @Autowired
    LoggingService service;

    @Override
    public void logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) {
        service.logEventForCurrentUser(LogCategory.LOGOUT, null);
    }
}
