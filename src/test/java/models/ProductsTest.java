package models;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductsTest {

    @Test
    @DisplayName("Products Instantiates Correctly.")
    public void testInstanceOfProducts_true(){
        Products testProducts = setUpProducts();
        assertEquals(true, testProducts instanceof Products);
    }

    @Test
    @DisplayName("Products Instantiates Correctly with id 1.")
    public void testInstanceWithId_1(){
        Products testProducts = setUpProducts();
        assertEquals(1, testProducts.getId());
    }

    @Test
    @DisplayName("Products Instantiates Correctly with name product.")
    public void testInstanceWithName_product(){
        Products testProducts = setUpProducts();
        assertEquals("product", testProducts.getName());
    }

    @Test
    @DisplayName("Products Instantiates Correctly with category.")
    public void testInstanceWithCategory_category(){
        Products testProducts = setUpProducts();
        assertEquals("category", testProducts.getCategory());
    }



    //helper method.
    private Products setUpProducts() {
        return new Products (1, "product", "category", 2);
    }

}