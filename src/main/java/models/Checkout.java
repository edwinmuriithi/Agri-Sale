package models;

public class Checkout {
    private int id;
    private String name_of_item;
    private int price_of_item;
    private int price;

    //constructor
    public Checkout(String name_of_item, int price_of_item, int price) {
        this.name_of_item = name_of_item;
        this.price_of_item = price_of_item;
        this.price = price;
    }

    //getters
    public String getNameOfItem() {
        return name_of_item;
    }

    public int getPriceOfItem() {
        return price_of_item;
    }

    public int getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    //setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNameOfItem(String name_of_item) {
        this.name_of_item = name_of_item;
    }
}
