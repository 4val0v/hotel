package ru.relex.practice.dao;

import ru.relex.practice.model.LogType;
import ru.relex.practice.model.User;

/**
 * Data Access Object для логирования
 */
public interface LoggingDao {

    /**
     * Получает объект события по его идентификатору
     * @param logTypeId идентификатор события
     * @return объект лога события или {@code null}
     */
    LogType getLoggingEvent(long logTypeId);

    /**
     * Создаёт лог события
     * @param user пользователь, порождающий событие
     * @param logType тип события
     * @param message дополнительная информация о событии
     */
    void logEvent(User user, LogType logType, String message);

}
