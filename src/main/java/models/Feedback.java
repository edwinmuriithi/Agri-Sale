package models;

public class Feedback {

    private int id;
    private String name;
    private String message;

    //constructor
    public Feedback(int id, String name, String message) {
        this.id = id;
        this.name = name;
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
}
