package dao;
import models.Products;
import models.Feedback;
import models.Checkout;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

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

}
