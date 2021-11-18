package dao.interfaces;
import models.Products;
import models.Checkout;
import models.Feedback;
import java.util.List;

public interface ProductsDao{

    //Create
    void add(Products products);

    //Retrieve
    List<Products> getAll();
    Products findById(int id);

    //Update
    void update(int id, String name, String category, int price);

    //Delete
    void deleteById(int id);
    void clearAll();

}

