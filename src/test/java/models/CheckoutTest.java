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
    @DisplayName("Checkout Instantiates Correctly with price_of_item 1.")
    public void testInstanceWithPriceOfItem_1(){
        Checkout testCheckout = setUpCheckOut();
        testCheckout.setPriceOfItem(1);
        assertEquals(1, testCheckout.getPriceOfItem());
    }

    @Test
    @DisplayName("Checkout Instantiates Correctly with price 2.")
    public void testInstanceWithPrice_2(){
        Checkout testCheckout = setUpCheckOut();
        testCheckout.setPrice(2);
        assertEquals(2, testCheckout.getPrice());
    }

    @Test
    @DisplayName("Checkout Instantiates Correctly with product_Id 2.")
    public void testInstanceWithProductId_2(){
        Checkout testCheckout = setUpCheckOut();
        testCheckout.setPrice(2);
        assertEquals(2, testCheckout.getProduct_id());
    }

    @Test
    @DisplayName("Checkout sets the Id to 2.")
    public void setId_setsIdTo_2() {
        Checkout testCheckout = setUpCheckOut();
        testCheckout.setId(2);
        assertEquals(2, testCheckout.getId());
    }

    @Test
    @DisplayName("Checkout sets the name_of_item to tomato.")
    public void setNameOfItem_setsNameOfItem_tomato() {
        Checkout testCheckout = setUpCheckOut();
        testCheckout.setNameOfItem("tomato");
        assertEquals("tomato", testCheckout.getNameOfItem());
    }

    @Test
    @DisplayName("Checkout sets the price_of_item to 2.")
    public void setPriceOfItem_setsPriceOfItem_2() {
        Checkout testCheckout = setUpCheckOut();
        testCheckout.setPriceOfItem(2);
        assertEquals(2, testCheckout.getPriceOfItem());
    }

    @Test
    @DisplayName("Checkout sets the price to 1.")
    public void setPrice_setsPrice_1() {
        Checkout testCheckout = setUpCheckOut();
        testCheckout.setPrice(1);
        assertEquals(1, testCheckout.getPrice());
    }

    @Test
    @DisplayName("Checkout sets the price to 1.")
    public void setPrice_setsProduct_Id_1() {
        Checkout testCheckout = setUpCheckOut();
        testCheckout.setProduct_id(1);
        assertEquals(1, testCheckout.getProduct_id());
    }

    @Test
    @DisplayName("Compare objects")
    public void returnTrueIfNameAndTypeAreTheSame_true() {
        Checkout testCheckout = setUpCheckOut();
        Checkout testCheckout2 = setUpCheckOut();
        assertTrue(testCheckout.equals(testCheckout2));
    }

    //helper method.
    private Checkout setUpCheckOut() {
        return new Checkout ( 1, 2);
    }
}