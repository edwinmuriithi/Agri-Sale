package models;

import java.util.Objects;

public class Checkout {

    private int id;
    private String name_of_item;
    private int price_of_item;
    private int price;
    private int product_id;

    //constructor
    public Checkout(int id, int product_id) {
        this.product_id = product_id;
        this.id = id;
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

    public int getProduct_id() {
        return product_id;
    }

    //setters
    public void setId(int id) {
        this.id = id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public void setNameOfItem(String name_of_item) {
        this.name_of_item = name_of_item;
    }

    public void setPriceOfItem(int price_of_item) {
        this.price_of_item = price_of_item;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Checkout)) return false;
        Checkout checkout = (Checkout) o;
        return price_of_item == checkout.price_of_item && Objects.equals(name_of_item, checkout.name_of_item);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name_of_item, price_of_item);
    }

}
