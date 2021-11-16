package models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FeedbackTest {

    @Test
    @DisplayName("Checkout Instantiates Correctly.")
    public void testInstanceOfCheckout_true(){
        Feedback testFeedback = setUpFeedback();
        assertEquals(true, testFeedback instanceof Feedback);
    }




    //helper method.
    private Feedback setUpFeedback() {
        return new Feedback (1, "user", "message");
    }

}