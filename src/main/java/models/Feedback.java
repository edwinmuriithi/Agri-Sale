package models;

import java.util.Objects;

public class Feedback {

    private int id;
    private String name;
    private String message;
    private String email;

    //constructor
    public Feedback(String name, String email, String message) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.message = message;
    }

    //getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }

    //setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Feedback)) return false;
        Feedback feedback = (Feedback) o;
        return getId() == feedback.getId() && getName().equals(feedback.getName()) && getMessage().equals(feedback.getMessage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getMessage());
    }
}
