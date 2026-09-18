/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author kumar
 */
package model;

public class Bicycle extends Product {

    private String condition;

    public Bicycle(int productId, int sellerId, String name,
                   String description, double price,
                   String status, String condition) {

        super(productId, sellerId, name, "Bicycles",
              description, price, status);

        this.condition = condition;
    }

    public String getCondition() {
        return condition;
    }
}
