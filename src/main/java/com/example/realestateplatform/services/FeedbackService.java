package com.example.realestateplatform.services;

import com.example.realestateplatform.model.Feedback;

import java.util.List;

public interface FeedbackService {
    public Feedback saveFeedback(Feedback feedback);
        public List<Feedback> GetAllFeedback();
        public void deleteFeedback(String email);
}
