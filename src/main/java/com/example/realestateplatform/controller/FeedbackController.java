package com.example.realestateplatform.controller;
import com.example.realestateplatform.model.Feedback;
import com.example.realestateplatform.services.FeedbackService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FeedbackController {
    private final FeedbackService feedbackService;

    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }
    @GetMapping("/feedback")
    public String viewFeedback(Model model){
        model.addAttribute("feedback", new Feedback());
        return "feedback";
    }
    @GetMapping("/display")
    public String displayFeedback(Model model){
        model.addAttribute("display",feedbackService.GetAllFeedback());
        return "displayFeedback";
    }
    @PostMapping("/regFeedback")
    public String saveFeedback(@ModelAttribute("feedback") Feedback feedback) {
        Feedback feedback1 = feedbackService.saveFeedback(feedback);
        if (feedback1 != null) {
            return "redirect:/feedback?success";
        } else {
            return "redirect:/feedback?error";
        }
    }
    @GetMapping("/display/{emails}")
public String deleteFeedback(@PathVariable String emails){
        feedbackService.deleteFeedback(emails);
        return "redirect:/display";
    }
}
