package service;

import model.Product;
import exception.InvalidProductException;

public interface ProductOperations {

    void addProduct(Product product);

    void displayProduct(Product product);

    void markAsSold(Product product);

    void validateProduct(Product product)
            throws InvalidProductException;

    void searchProduct(String keyword);

    void filterByPrice(double maxPrice);

    void searchByCategory(String category);
}