package dao;

<<<<<<< HEAD
import interfaces.FeedbackDao;
=======
import dao.interfaces.FeedbackDao;
>>>>>>> f9d7b2af47804d4b1382b5cc66be6151e30c0451
import models.Feedback;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

<<<<<<< HEAD
import java.sql.Connection;
=======
>>>>>>> f9d7b2af47804d4b1382b5cc66be6151e30c0451
import java.util.List;

public class Sql2oFeedbackDao implements FeedbackDao {
    private final Sql2o sql2o;
    public Sql2oFeedbackDao(Sql2o sql2o){
        this.sql2o = sql2o;
    }

    @Override
    public List<Feedback> getAllFeedbacks() {
        try(Connection con =sql2o.open()){
            return con.createQuery("SELECT * FROM feedback")
                    .executeAndFetch(Feedback.class);
        }
    }

    @Override
    public void addFeedback(Feedback feedback){
<<<<<<< HEAD
        String sql = "INSERT INTO feedback (name,message) VALUES(:name, :message)";
=======
        String sql = "INSERT INTO feedback (name, email, message) VALUES(:name, :email, :message)";
>>>>>>> f9d7b2af47804d4b1382b5cc66be6151e30c0451
        try(Connection con = sql2o.open()){
            int id = (int) con.createQuery(sql,true)
                    .bind(feedback)
                    .executeUpdate()
                    .getKey();
            feedback.setId(id);
        }
    }

    @Override
    public Feedback findFeedbackById(int id){
        String sql = "SELECT * FROM feedback WHERE id=:id";
        try(Connection con = sql2o.open()){
            return con.createQuery(sql)
                    .addParameter("id",id)
                    .executeAndFetchFirst(Feedback.class);
        }
    }

    @Override
    public void updateFeedback(Feedback feedback, String name, String message){
        String sql = "UPDATE feedback SET (name,message) = (:name, :message) WHERE id =:id";
        try(Connection con = sql2o.open()){
            con.createQuery(sql)
                    .addParameter("name", name)
                    .addParameter("message",message)
                    .addParameter("id",feedback.getId())
                    .executeUpdate();
            feedback.setName(name);
            feedback.setMessage(message);
        }
    }

    @Override
    public void clearAllFeedbacks(){
        String sql = "DELETE FROM feedback";
        try(Connection con = sql2o.open()){
            con.createQuery(sql)
                    .executeUpdate();
        }
    }

<<<<<<< HEAD
}
=======
}
>>>>>>> f9d7b2af47804d4b1382b5cc66be6151e30c0451
