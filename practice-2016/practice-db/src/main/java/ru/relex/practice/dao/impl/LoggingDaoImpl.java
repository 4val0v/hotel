package ru.relex.practice.dao.impl;

import org.springframework.stereotype.Repository;
import ru.relex.practice.dao.LoggingDao;
import ru.relex.practice.model.Log;
import ru.relex.practice.model.LogType;
import ru.relex.practice.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class LoggingDaoImpl implements LoggingDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public LogType getLoggingEvent(long logTypeId) {
        List<LogType> logTypes = entityManager.createQuery("FROM LogType WHERE id = :id", LogType.class).setParameter("id", logTypeId).getResultList();
        return logTypes.isEmpty() ? null : logTypes.get(0);
    }

    @Override
    public void logEvent(User user, LogType logType, String message) {
        Log log = new Log();
        log.setMessage(message);
        log.setType(logType);
        log.setUser(user);
        entityManager.persist(log);
    }


}
