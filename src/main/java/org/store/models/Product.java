package org.store.models;

public class Product {
    private String name;
    private String category;
    private Integer price;
    private Integer manufacturingDate;
    private Integer expiryDate;
    private Integer quantity;


    public Product(String name, String category, Integer price, Integer manufacturingDate, Integer expiryDate, Integer quantity) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.manufacturingDate = manufacturingDate;
        this.expiryDate = expiryDate;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getManufacturingDate() {
        return manufacturingDate;
    }

    public void setManufacturingDate(Integer manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    public Integer getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Integer expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Products{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", manufacturingDate=" + manufacturingDate +
                ", expiryDate=" + expiryDate +
                ", batchNo=" + quantity +
                '}';
    }
}
