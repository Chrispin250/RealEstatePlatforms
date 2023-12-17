package com.example.realestateplatform.services.implementation;

import com.example.realestateplatform.model.Feedback;
import com.example.realestateplatform.repository.FeedbackRepository;
import com.example.realestateplatform.services.FeedbackService;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
@Lazy
@Service
public class FeedbackImpl implements FeedbackService {

    private final FeedbackRepository feedbackRepository;

    public FeedbackImpl(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    @Override
    public Feedback saveFeedback(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    @Override
    public List<Feedback> GetAllFeedback() {
        return feedbackRepository.findAll();
    }

    @Override
    public void deleteFeedback(String email) {
        feedbackRepository.deleteById(email);
    }
}
