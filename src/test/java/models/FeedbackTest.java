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
    public void getId_ReturnsId_1(){
        Feedback testFeedback = setUpFeedback();
        assertEquals(1, testFeedback.getId());
    }

    @Test
    @DisplayName("Feedback Instantiates Correctly with name.")
    public void getName_ReturnsName_user(){
        Feedback testFeedback = setUpFeedback();
        assertEquals("user", testFeedback.getName());
    }

    @Test
    @DisplayName("Feedback Instantiates Correctly with message.")
    public void getMessage_ReturnsMessage_message(){
        Feedback testFeedback = setUpFeedback();
        assertEquals("message", testFeedback.getMessage());
    }

    @Test
    @DisplayName("Feedback Correctly sets id to 2.")
    public void setId_SetsId_2(){
        Feedback testFeedback = setUpFeedback();
        testFeedback.setId(1);
        assertEquals(1, testFeedback.getId());
    }

    @Test
    @DisplayName("Feedback Correctly sets name to admin.")
    public void setName_SetsName_admin(){
        Feedback testFeedback = setUpFeedback();
        testFeedback.setName("admin");
        assertEquals("admin", testFeedback.getName());
    }

    @Test
    @DisplayName("Feedback Correctly sets message to thanks.")
    public void setMessage_SetsMessage_thanks(){
        Feedback testFeedback = setUpFeedback();
        testFeedback.setMessage("thanks");
        assertEquals("thanks", testFeedback.getMessage());
    }

    @Test
    @DisplayName("Compare objects")
    public void returnTrueIfObjectsAreTheSame_true() {
        Feedback testFeedback = setUpFeedback();
        Feedback testFeedback2 = setUpFeedback();
        assertTrue(testFeedback.equals(testFeedback2));
    }


    //helper method.
    private Feedback setUpFeedback() {
        return new Feedback( "user", "email", "message");
    }

}