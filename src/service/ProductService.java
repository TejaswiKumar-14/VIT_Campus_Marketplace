package service;

import model.Product;
import exception.InvalidProductException;
import java.util.ArrayList;

public class ProductService implements ProductOperations {

    private ArrayList<Product> products = new ArrayList<>();

    private ActivityLogger logger =
            new ActivityLogger();

    @Override
    public void addProduct(Product product) {

        products.add(product);

        System.out.println(
                "Product added successfully."
        );

        System.out.println(
                "Product Name: "
                + product.getName()
        );

        logger.logActivity(
                "Product added: "
                + product.getName()
        );
    }

    @Override
    public void displayProduct(Product product) {

        System.out.println(
                "\n===== PRODUCT DETAILS ====="
        );

        System.out.println(
                "Product ID: "
                + product.getProductId()
        );

        System.out.println(
                "Name: "
                + product.getName()
        );

        System.out.println(
                "Category: "
                + product.getCategory()
        );

        System.out.println(
                "Description: "
                + product.getDescription()
        );

        System.out.println(
                "Price: Rs. "
                + product.getPrice()
        );

        System.out.println(
                "Status: "
                + product.getStatus()
        );
    }

    @Override
    public void markAsSold(Product product) {

        System.out.println(
                "Product marked as sold."
        );

        logger.logActivity(
                "Product marked as sold: "
                + product.getName()
        );
    }

    @Override
    public void validateProduct(Product product)
            throws InvalidProductException {

        if (product.getName() == null
                || product.getName()
                        .trim()
                        .isEmpty()) {

            throw new InvalidProductException(
                    "Product name cannot be empty."
            );
        }

        if (product.getPrice() <= 0) {

            throw new InvalidProductException(
                    "Product price must be greater than zero."
            );
        }

        System.out.println(
                "Product validation successful."
        );

        logger.logActivity(
                "Product validation successful: "
                + product.getName()
        );
    }

    public void displayAllProducts() {

        System.out.println(
                "\n===== ALL PRODUCTS ====="
        );

        for (Product product : products) {

            System.out.println(
                    "ID: "
                    + product.getProductId()
            );

            System.out.println(
                    "Name: "
                    + product.getName()
            );

            System.out.println(
                    "Category: "
                    + product.getCategory()
            );

            System.out.println(
                    "Price: Rs. "
                    + product.getPrice()
            );

            System.out.println(
                    "Status: "
                    + product.getStatus()
            );

            System.out.println(
                    "------------------------"
            );
        }
    }

    @Override
    public void searchProduct(String keyword) {

        boolean found = false;

        System.out.println(
                "\n===== SEARCH RESULTS ====="
        );

        for (Product product : products) {

            if (product.getName()
                    .toLowerCase()
                    .contains(
                            keyword.toLowerCase()
                    )) {

                System.out.println(
                        "ID: "
                        + product.getProductId()
                );

                System.out.println(
                        "Name: "
                        + product.getName()
                );

                System.out.println(
                        "Category: "
                        + product.getCategory()
                );

                System.out.println(
                        "Price: Rs. "
                        + product.getPrice()
                );

                System.out.println(
                        "Status: "
                        + product.getStatus()
                );

                System.out.println(
                        "------------------------"
                );

                found = true;
            }
        }

        logger.logActivity(
                "Product search performed: "
                + keyword
        );

        if (!found) {

            System.out.println(
                    "No product found."
            );
        }
    }

    @Override
    public void filterByPrice(double maxPrice) {

        boolean found = false;

        System.out.println(
                "\n===== PRODUCTS WITHIN BUDGET ====="
        );

        for (Product product : products) {

            if (product.getPrice() <= maxPrice) {

                System.out.println(
                        "Product ID: "
                        + product.getProductId()
                );

                System.out.println(
                        "Name: "
                        + product.getName()
                );

                System.out.println(
                        "Category: "
                        + product.getCategory()
                );

                System.out.println(
                        "Price: Rs. "
                        + product.getPrice()
                );

                System.out.println(
                        "Status: "
                        + product.getStatus()
                );

                System.out.println(
                        "------------------------"
                );

                found = true;
            }
        }

        logger.logActivity(
                "Price filter used: Rs. "
                + maxPrice
        );

        if (!found) {

            System.out.println(
                    "No products found within this budget."
            );
        }
    }

    @Override
    public void searchByCategory(
            String category) {

        boolean found = false;

        System.out.println(
                "\n===== CATEGORY SEARCH RESULTS ====="
        );

        for (Product product : products) {

            if (product.getCategory()
                    .equalsIgnoreCase(category)) {

                System.out.println(
                        "Product ID: "
                        + product.getProductId()
                );

                System.out.println(
                        "Name: "
                        + product.getName()
                );

                System.out.println(
                        "Category: "
                        + product.getCategory()
                );

                System.out.println(
                        "Price: Rs. "
                        + product.getPrice()
                );

                System.out.println(
                        "Status: "
                        + product.getStatus()
                );

                System.out.println(
                        "------------------------"
                );

                found = true;
            }
        }

        logger.logActivity(
                "Category search performed: "
                + category
        );

        if (!found) {

            System.out.println(
                    "No products found in this category."
            );
        }
    }

    // Returns all products
    public ArrayList<Product> getProducts() {

        return products;
    }
}