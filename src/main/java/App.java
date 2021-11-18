import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.Sql2oProductsDao;
import dao.Sql2oCheckoutDao;
import dao.Sql2oFeedbackDao;
import models.Checkout;
import models.Products;
import models.Feedback;
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
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }

    public static void main(String[] args) {

        String connectionString = "jdbc:postgresql://localhost:5432/agri_sale";
        Sql2o sql2o = new Sql2o(connectionString, "moringa", "Access");
        port(getHerokuAssignedPort());

        staticFileLocation("/public");
        Sql2oFeedbackDao feedbackDao = new Sql2oFeedbackDao(sql2o);
        Sql2oProductsDao productsDao = new Sql2oProductsDao(sql2o);

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "index.hbs");
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
//



    }

}