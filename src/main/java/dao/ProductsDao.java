package dao;
import models.Products;
import models.Checkout;
import models.Feedback;
import java.util.List;

public interface ProductsDao{
    //add a new product
    void add(Products products);

    //view all products
    List<Products> getAll();

    //view a single product
    Products findById(int id);

    //update
    void update(int id, String name, String category, int price);

    //delete a single product
    void deleteById(int id);

    //delete all products
    void clearAll();
}

