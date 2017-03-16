package ru.relex.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.relex.practice.service.LoggingService;

import java.security.Principal;

/**
 * Аутентификационные точки входа в приложения
 */
@Controller
@RequestMapping("/auth")
public class LoginController {

    @Autowired
    LoggingService loggingService;

    /**
     * @param principal текущий пользователь системы
     * @return страница логина если пользователь не задан. Иначе редиректит на главную
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)

    public String loginPage(Principal principal) {
        if (principal != null && principal.getName() != null) {
            return "redirect:/index";
        }
        return "login";
    }
}
