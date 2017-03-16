package ru.relex.practice.mappings;

import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import ru.relex.practice.dao.LoggingDao;
import ru.relex.practice.enumeration.LogCategory;
import ru.relex.practice.model.LogType;

import java.util.HashMap;
import java.util.Map;

/**
 * Выполняет преобразования между объектами таблицы-словаря из БД и перечислением.
 */
@Mapper(componentModel = "spring")
public abstract class LogMapper {

    @Autowired
    LoggingDao loggingDao;

    private static final Map<Long, LogType> CACHED_LOG_TYPES = new HashMap<>();

    public LogCategory logTypeToCategory(LogType logType) {
        assert logType != null : "logType must be set";

        return LogCategory.getById(logType.getId());
    }

    public LogType logCategoryToType(LogCategory logCategory) {
        assert logCategory != null : "logCategory must be set";
        if (!CACHED_LOG_TYPES.containsKey(logCategory.getId())) {
            CACHED_LOG_TYPES.put(logCategory.getId(), loggingDao.getLoggingEvent(logCategory.getId()));
        }
        return CACHED_LOG_TYPES.get(logCategory.getId());
    }
}
