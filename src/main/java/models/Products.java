package models;

public class Products {
    private int id;
    private String name;
    private String category;
    private int price;

    //constructor
    public Products(int id, String name, String category, int price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    //getters
    public int getId() {
        return id;
    }


    //setters
}
