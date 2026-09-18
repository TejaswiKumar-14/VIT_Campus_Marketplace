/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author kumar
 */
package model;

public class Book extends Product {

    private String author;

    public Book(int productId, int sellerId, String name,
                String description, double price,
                String status, String author) {

        super(productId, sellerId, name, "Books",
              description, price, status);

        this.author = author;
    }

    public String getAuthor() {
        return author;
    }
}
