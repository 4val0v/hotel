package ru.relex.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.relex.practice.dto.EmailDTO;
import ru.relex.practice.service.EmailService;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/")
public class EmailController {

    @Autowired
    EmailService emailService;

    @RequestMapping(value = "emails", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<EmailDTO> getEmailList() {
        return emailService.getEmails();
    }
}