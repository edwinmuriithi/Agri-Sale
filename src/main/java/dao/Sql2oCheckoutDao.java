package dao;
import dao.interfaces.CheckoutDao;
import models.Checkout;
import models.Products;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oCheckoutDao implements CheckoutDao {

    private final Sql2o sql2o;
    public Sql2oCheckoutDao (Sql2o sql2o)
    {
        this.sql2o = sql2o;
    }

    @Override
    public void add(Checkout checkout) {
        String sql = "INSERT INTO checkout (products_id) VALUES (:products_id)";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql, true)
                    .bind(checkout)
                    .executeUpdate()
                    .getKey();
            checkout.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
            System.out.println("Added product to Checkout succesfully.");
        }
    }

    @Override
    public List<Products> getProductByproduct_id(int products_id) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM products WHERE id = :products_id")
                    .addParameter("products_id", products_id)
                    .executeAndFetch(Products.class);
        }
    }

    @Override
    public void clearAll() {
        String sql = "DELETE from checkout";
        try(Connection con = sql2o.open()){
            con.createQuery(sql)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
            System.out.println("Emptied checkout.");
        }

    }

    @Override
    public void deleteById(int id) {
            String sql = "DELETE from checkout WHERE  id = :id";
            try (Connection con = sql2o.open()){
                con.createQuery(sql)
                        .addParameter("id", id)
                        .executeUpdate();
            } catch (Sql2oException ex){
                System.out.println(ex);
                System.out.println("Deleted product by Id successfully.");
            }
         }

}
