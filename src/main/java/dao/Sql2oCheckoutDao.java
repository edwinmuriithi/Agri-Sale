package dao;
import models.Products;
import models.Feedback;
import models.Checkout;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oCheckoutDao implements CheckoutDao{
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
        }
    }


    @Override
    public List<Checkout> getProductByproduct_id(int products_id) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM checkout WHERE products_id = :products_id")
                    .addParameter("products_id", products_id)
                    .executeAndFetch(Checkout.class);
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
        }

    }

}
