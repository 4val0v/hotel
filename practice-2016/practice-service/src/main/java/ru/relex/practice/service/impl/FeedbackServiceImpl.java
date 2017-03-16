package ru.relex.practice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.relex.practice.dao.FeedbackDao;
import ru.relex.practice.dto.FeedbackDTO;
import ru.relex.practice.mappings.FeedbackMapper;
import ru.relex.practice.model.Feedback;
import ru.relex.practice.service.FeedbackService;
import ru.relex.practice.util.SecurityUtil;

import java.util.List;

@Service("feedbackService")
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    FeedbackDao feedbackDao;

    @Autowired
    FeedbackMapper feedbackMapper;

    @Autowired
    FeedbackService feedbackService;

    @Transactional
    @Override
    public FeedbackDTO saveFeedback(String theme, String email, String message) {
        Feedback feedback = feedbackDao.createFeedback(theme, email, message);
        return feedbackMapper.feedbackToDto(feedback);
    }

    @Transactional
    @Override
    public FeedbackDTO saveFeedbackFromJson(FeedbackDTO fdbck) {
        Feedback feedback = feedbackDao.createFeedback(fdbck.getTheme(), fdbck.getEmail(), fdbck.getMessage());
        return feedbackMapper.feedbackToDto(feedback);
    }

    @Override
    public List<FeedbackDTO> getFeedback() {
        return feedbackMapper.feedbacksToDtos(feedbackDao.getFeedback());
    }

    @Override
    public List<FeedbackDTO> getThreeMessages() {
        return feedbackMapper.feedbacksToDtos(feedbackDao.getThreeFeedbacks());
    }
}
