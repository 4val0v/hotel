package ru.relex.practice.dao;

import ru.relex.practice.model.Feedback;

import java.util.List;

public interface FeedbackDao {
    /**
     * создает новое сообщение
     * @param theme - тема сообщения
     * @param email - почта отправителя
     * @param message - сообщение
     * @return идентификатор сообщения
     */
    Feedback createFeedback(String theme, String email, String message);

    /**
     * возвращает список всех сообщений
     */
    List<Feedback> getFeedback();

    /**
     * возвращает три последних сообщения
     */
    List<Feedback> getThreeFeedbacks();
}
