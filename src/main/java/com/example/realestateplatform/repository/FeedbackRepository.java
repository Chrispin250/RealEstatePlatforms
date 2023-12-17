package com.example.realestateplatform.repository;

import com.example.realestateplatform.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, String> {
}
