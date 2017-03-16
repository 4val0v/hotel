package ru.relex.practice.service;

import ru.relex.practice.dto.UserDTO;
import ru.relex.practice.enumeration.LogCategory;

/**
 * Логирует события в БД
 */
public interface LoggingService {

    /**
     * Логирует событие для текущего пользователя
     * @param category категория логгируемого события
     * @param message дополнительное сообщнение
     */
    void logEventForCurrentUser(LogCategory category, String message);

    /**
     * Логирует событие для заданного пользователя
     * @param category категория логгируемого события
     * @param user
     * @param message дополнительное сообщнение
     */
    void logEvent(LogCategory category, UserDTO user, String message);

    /**
     * Логирует событие
     * @param category категория логгируемого события
     * @param message дополнительное сообщнение
     */
    void logEvent(LogCategory category, String message);
}
