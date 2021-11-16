package dao;

import models.Feedback;

import java.util.List;

public interface FeedbackDao {
    List<Feedback> getAllFeedbacks();
    void addFeedback(Feedback feedback);
    Feedback findFeedbackById(int id);
    void updateFeedbacks(Feedback feedback, String name, String message);
    void clearAllFeedbacks();
}
