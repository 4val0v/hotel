package ru.relex.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.relex.practice.dto.RoomDTO;
import ru.relex.practice.dto.FeedbackDTO;
import ru.relex.practice.dto.EmailDTO;
import ru.relex.practice.service.RoomService;
import ru.relex.practice.service.FeedbackService;
import ru.relex.practice.service.EmailService;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

import java.util.List;

@Controller
@RequestMapping("/main")
public class MainController {

    @Autowired
    RoomService roomService;

    @Autowired
    FeedbackService feedbackService;

    @Autowired
    EmailService emailService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public @ResponseBody List<RoomDTO> indexPage() {
        return roomService.getTopFive();
    }

    @RequestMapping(value = "fdbck", method = RequestMethod.GET)
    public @ResponseBody List<FeedbackDTO> fdbckOnIndexPage() {
        return feedbackService.getThreeMessages();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public String getEmail(@RequestBody EmailDTO email) {
        EmailDTO emailDTO = emailService.saveEmailFromJson(email);
        return "SUCCESS";
    }
}
