package dao;
import models.Products;
import models.Checkout;
import models.Feedback;
import java.util.List;

public interface CheckoutDao {
    //add a new product to checkout
    void add(Checkout checkout);

    //view all products in checkout
    List<Checkout> getAll();

    //view a single product in checkout
    Checkout findById(int id);

    //update product in checkout
    void update(int id, String name, String category, int price);

    //delete a single product in checkout
    void deleteById(int id);

    //delete all products in checkout
    void clearAll();
}
