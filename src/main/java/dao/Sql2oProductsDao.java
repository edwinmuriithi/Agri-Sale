package dao;

import dao.interfaces.ProductsDao;
import models.Products;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

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

    @Override
    public Products findById(int id) {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM products WHERE id = :id")
                    .addParameter("id",id)
                    .executeAndFetchFirst(Products.class);
        }
    }

    @Override
    public void update(int id, String name, String category, int price) {
        String sql = "UPDATE products SET (name, category, price) = (:name, :category, :price) WHERE id=:id";
        try (Connection con = sql2o.open()){
            con.createQuery(sql)
                    .addParameter("name",name)
                    .addParameter("category",category)
                    .addParameter("price",price)
                    .addParameter("id",id)
                    .executeUpdate();
        }catch (Sql2oException ex){
            System.out.println(ex);
            System.out.println("Updated product by Id.");
        }

    }

    @Override
    public void deleteById(int id) {
        String sql =" DELETE from products WHERE id = :id";
        try (Connection con = sql2o.open()){
            con.createQuery(sql)
                    .addParameter("id",id)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
            System.out.println("Deleted product by Id successfully.");
        }

    }

    @Override
    public void clearAll() {
        String sql = "DELETE from products";
        try(Connection con = sql2o.open()){
            con.createQuery(sql)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
            System.out.println("Deleted all products.");
        }

    }

}
