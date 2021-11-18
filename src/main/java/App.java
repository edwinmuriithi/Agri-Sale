import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.google.gson.Gson;

import dao.Sql2oCheckoutDao;
import dao.Sql2oFeedbackDao;
import dao.Sql2oProductsDao;
import models.Feedback;
import models.Checkout;
import models.Products;
import org.sql2o.Sql2o;
import org.sql2o.Sql2o;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;

public class App {

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4568; //return default port if heroku-port isn't set (i.e. on localhost)
    }

    public static void main(String[] args) {

        //Heroku
        port(getHerokuAssignedPort());

        staticFileLocation("/public");

        //connect to Db.
        //Local
        String connectionString = "jdbc:postgresql://localhost:5432/agri_sale";
        Sql2o sql2o = new Sql2o(connectionString, "moringa", "1234567890");

        //Remote
//        String connectionString = "jdbc:postgresql://ec2-23-21-148-223.compute-1.amazonaws.com:5432/das9arqqcn3fum";
//        Sql2o sql2o = new Sql2o(connectionString, "inbpxrhqhbakjf", "a2042a3b3e07a3f8015f0e7e1a5075d3a748b578f8c01893c589cdcce552e11d");

        Sql2oFeedbackDao feedbackDao = new Sql2oFeedbackDao(sql2o);
        Sql2oProductsDao productsDao = new Sql2oProductsDao(sql2o);
        Sql2oCheckoutDao checkoutDao = new Sql2oCheckoutDao(sql2o);

        //get

        //get all products
        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Products> products = productsDao.getAll();
            model.put("products", products);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        //get a specific product
        get("/products/:id", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfProductToFind = Integer.parseInt(req.params("id")); //new
            Products foundProducts = productsDao.findById(idOfProductToFind);
            model.put("products", foundProducts);
            return new ModelAndView(model, "category-detail.hbs"); //new
        }, new HandlebarsTemplateEngine());

        //get: show a form to create a new feedback
        get("/feedback/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Feedback> feedbacks = feedbackDao.getAllFeedbacks();
            model.put("feedbacks", feedbacks);
            return new ModelAndView(model, "feedback-form.hbs"); //new layout
        }, new HandlebarsTemplateEngine());

        //get: checkout
        get("/checkout", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Products> products = productsDao.getAll();
            model.put("products", products);
            return new ModelAndView(model, "checkout.hbs");
        }, new HandlebarsTemplateEngine());

        //get: delete all products
        get("/products/delete", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            productsDao.clearAll();
            res.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());

        //get: add product by id to checkout

        //get: delete a product from Checkout by id
        get("/checkout/:id/products/:product_id/delete", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfProductToDelete = Integer.parseInt(req.params("product_id"));
            productsDao.deleteById(idOfProductToDelete);
            res.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());

        //post

        //post: process a form to create a new feedback
        post("/feedback", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            String name = req.queryParams("name");
            String email = req.queryParams("email");
            String message = req.queryParams("message");
            Feedback newFeedback = new Feedback(name, email, message);
            feedbackDao.addFeedback(newFeedback);
            res.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());


        get("/feedback/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Feedback> feedbacks = feedbackDao.getAllFeedbacks();
            model.put("feedbacks", feedbacks);
            return new ModelAndView(model, "feedback.hbs"); //new layout
        }, new HandlebarsTemplateEngine());

        post("/feedback", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            String name = req.queryParams("name");
            String email = req.queryParams("email");
            String message = req.queryParams("message");
            Feedback newFeedback = new Feedback(name, email, message);
            feedbackDao.addFeedback(newFeedback);
            res.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());


    }

}