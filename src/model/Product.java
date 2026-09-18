package model;

public class Product {

    private int productId;
    private int sellerId;
    private String name;
    private String category;
    private String description;
    private double price;
    private String status;

    public Product(int productId, int sellerId,
                   String name, String category,
                   String description, double price,
                   String status) {

        this.productId = productId;
        this.sellerId = sellerId;
        this.name = name;
        this.category = category;
        this.description = description;
        this.price = price;
        this.status = status;
    }

    // Getter for Product ID
    public int getProductId() {
        return productId;
    }

    // Getter for Seller ID
    public int getSellerId() {
        return sellerId;
    }

    // Getter for Product Name
    public String getName() {
        return name;
    }

    // Getter for Category
    public String getCategory() {
        return category;
    }

    // Getter for Description
    public String getDescription() {
        return description;
    }

    // Getter for Price
    public double getPrice() {
        return price;
    }

    // Getter for Status
    public String getStatus() {
        return status;
    }

    // Setter for Status
    public void setStatus(String status) {
        this.status = status;
    }
}