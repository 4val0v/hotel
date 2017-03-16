package ru.relex.practice.service;

/**
 * Интерфейс обратной связи
 */

import ru.relex.practice.dto.FeedbackDTO;
import ru.relex.practice.model.Feedback;

import java.util.List;

public interface FeedbackService {
    /**
     * сохраняет новое сообщение
     * @param theme - тема сообщения
     * @param email - эл. адрес отправителя (если указан)
     * @param message - сообщение
     * @return id сообщения
     */
    FeedbackDTO saveFeedback(String theme, String email, String message);

    /**
     * сохраняет сообщение из json
     * @param fdbck - сериализованный обЪект FeedbackDTO
     * @return Dto
     */

    FeedbackDTO saveFeedbackFromJson(FeedbackDTO fdbck);

    /**
     * получает список сообщений
     */
    List<FeedbackDTO> getFeedback();

    /**
     * получает три последних сообщения
     */
    List<FeedbackDTO> getThreeMessages();

}
