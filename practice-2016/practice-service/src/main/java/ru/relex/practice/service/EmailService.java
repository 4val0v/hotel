package ru.relex.practice.service;

import ru.relex.practice.dto.EmailDTO;
import ru.relex.practice.model.Email;

import java.util.List;

public interface EmailService {

    EmailDTO saveEmail(String email);

    EmailDTO saveEmailFromJson(EmailDTO email);

    List<EmailDTO> getEmails();
}