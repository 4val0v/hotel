package ru.relex.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.relex.practice.dto.FeedbackDTO;
import ru.relex.practice.service.FeedbackService;

import java.lang.reflect.Method;
import java.security.Principal;

import java.util.List;


@Controller
@RequestMapping("/")
public class FeedbackController {

    @Autowired
    FeedbackService feedbackService;

    @RequestMapping(value = "feedback", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<FeedbackDTO> fb_viewPage() {
        return feedbackService.getFeedback();
    }


}
