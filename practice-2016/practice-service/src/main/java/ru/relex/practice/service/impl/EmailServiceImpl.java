package ru.relex.practice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.relex.practice.dao.EmailDao;
import ru.relex.practice.dto.EmailDTO;
import ru.relex.practice.mappings.EmailMapper;
import ru.relex.practice.model.Email;
import ru.relex.practice.service.EmailService;
import ru.relex.practice.util.SecurityUtil;

import java.util.List;

@Service("emailService")
public class EmailServiceImpl implements EmailService {

    @Autowired
    EmailDao emailDao;

    @Autowired
    EmailMapper emailMapper;

    @Autowired
    EmailService emailService;

    @Transactional
    @Override
    public EmailDTO saveEmail(String email) {
        Email address = emailDao.createEmail(email);
        return emailMapper.emailToDto(address);
    }

    @Transactional
    @Override
    public EmailDTO saveEmailFromJson(EmailDTO email) {
        Email address = emailDao.createEmail(email.getEmail());
        return emailMapper.emailToDto(address);
    }

    @Override
    public List<EmailDTO> getEmails() {
        return emailMapper.emailsToDtos(emailDao.getEmails());
    }
}