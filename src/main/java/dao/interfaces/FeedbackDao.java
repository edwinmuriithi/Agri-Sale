package dao.interfaces;

import models.Feedback;

import java.util.List;

public interface FeedbackDao {

    //Create
    void addFeedback(Feedback feedback);

    //Retrieve
    List<Feedback> getAllFeedbacks();
    Feedback findFeedbackById(int id);

    //Update
    void updateFeedback(Feedback feedback, String name, String message);

    //Delete
    void clearAllFeedbacks();

}
