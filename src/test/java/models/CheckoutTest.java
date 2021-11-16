package models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckoutTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("Checkout Instantiates Correctly.")
    public void testInstanceOfCheckout_true(){
        Checkout testCheckout = setUpCheckOut();
        assertEquals(true, testCheckout instanceof Checkout);
    }

    @Test
    @DisplayName("Checkout Instantiates Correctly with name_of_item Potato.")
    public void testInstanceWithNameOfItem_potato(){
        Checkout testCheckout = setUpCheckOut();
        assertEquals("Potato", testCheckout.getNameOfItem());
    }







    //helper method.
    private Checkout setUpCheckOut() {
        return new Checkout ("Potato", 1, 2);
    }
}