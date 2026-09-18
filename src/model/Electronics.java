/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author kumar
 */
package model;

public class Electronics extends Product {

    private String brand;

    public Electronics(int productId, int sellerId, String name,
                       String description, double price,
                       String status, String brand) {

        super(productId, sellerId, name, "Electronics",
              description, price, status);

        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }
}
