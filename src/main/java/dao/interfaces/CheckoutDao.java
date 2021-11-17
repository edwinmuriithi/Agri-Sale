package dao.interfaces;
import models.Products;
import models.Checkout;
import models.Feedback;
import java.util.List;

public interface CheckoutDao {

    //Create
    void add(Checkout checkout);

    //Retrieve
    List<Products> getProductByproduct_id(int products_id);

    //Update

    //Delete
    void clearAll();
    void deleteById(int id);

}
