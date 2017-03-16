package ru.relex.practice.dao;

import ru.relex.practice.model.Email;

import java.util.List;

public interface EmailDao {
    Email createEmail(String email);

    List<Email> getEmails();
}