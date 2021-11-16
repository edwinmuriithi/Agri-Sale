package dao;
import models.Products;
import models.Checkout;
import models.Feedback;
import java.util.List;

public interface CheckoutDao {
    //add a new product to checkout
    void add(Checkout checkout);

    //get product by product id
    List<Checkout> getProductByproduct_id(int products_id);

    //delete all products in checkout
    void clearAll();
}
