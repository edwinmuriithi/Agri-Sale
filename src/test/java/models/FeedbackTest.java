package models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FeedbackTest {

    @Test
    @DisplayName("Feedback Instantiates Correctly.")
    public void testInstanceOfFeedback_true(){
        Feedback testFeedback = setUpFeedback();
        assertEquals(true, testFeedback instanceof Feedback);
    }

    @Test
    @DisplayName("Feedback Instantiates Correctly with id 1.")
    public void testInstanceOfFeedback_1(){
        Feedback testFeedback = setUpFeedback();
        assertEquals(1, testFeedback.getId());
    }




    //helper method.
    private Feedback setUpFeedback() {
        return new Feedback (1, "user", "message");
    }

}