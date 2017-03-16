package ru.relex.practice.dao.impl;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ru.relex.practice.dao.FeedbackDao;
import ru.relex.practice.model.Feedback;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

//@Controller("userDao")
@Component
@Repository
public class FeedbackDaoImpl implements FeedbackDao {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public Feedback createFeedback(String theme, String email, String message) {
        Feedback feedback = new Feedback();
        feedback.setTheme(theme);
        feedback.setEmail(email);
        feedback.setMessage(message);
        manager.persist(feedback);

        return feedback;
    }

    @Override
    public List<Feedback> getFeedback() {
        return manager.createQuery("FROM Feedback order by id desc", Feedback.class).getResultList();
    }

    @Override
    public List<Feedback> getThreeFeedbacks() {
        return manager.createQuery("from Feedback order by id desc", Feedback.class).setMaxResults(3).getResultList();
    }
}
