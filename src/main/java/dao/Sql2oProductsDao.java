package dao;
import models.Products;
import models.Feedback;
import models.Checkout;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.ArrayList;
import java.util.List;
public class Sql2oProductsDao implements ProductsDao {

    private final Sql2o sql2o;
    public Sql2oProductsDao (Sql2o sql2o)
    {
        this.sql2o = sql2o;
    }

    @Override
    public void add(Products products) {
        String sql = "INSERT INTO products (name, category, price) VALUES (:name, :category, :price)";
        try(Connection con = sql2o.open()){
            int id = (int)con.createQuery(sql, true)
                    .bind(products)
                    .executeUpdate()
                    .getKey();
            products.setId(id);
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public List<Products> getAll() {
        try(Connection con =sql2o.open()){
            return con.createQuery("SELECT * FROM products")
                    .executeAndFetch(Products.class);
        }
    }

}
