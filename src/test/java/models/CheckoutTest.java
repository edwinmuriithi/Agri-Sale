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

    @Test
    @DisplayName("Checkout Instantiates Correctly with price_of_item 1.")
    public void testInstanceWithPriceOfItem_1(){
        Checkout testCheckout = setUpCheckOut();
        assertEquals(1, testCheckout.getPriceOfItem());
    }

    @Test
    @DisplayName("Checkout Instantiates Correctly with price 2.")
    public void testInstanceWithPrice_2(){
        Checkout testCheckout = setUpCheckOut();
        assertEquals(2, testCheckout.getPrice());
    }

    @Test
    @DisplayName("Checkout sets the Id to 2.")
    public void setId_setsIdTo_2() {
        Checkout testCheckout = setUpCheckOut();
        testCheckout.setId(2);
        assertEquals(2, testCheckout.getId());
    }





    //helper method.
    private Checkout setUpCheckOut() {
        return new Checkout ("Potato", 1, 2);
    }
}