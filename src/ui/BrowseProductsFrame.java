package ui;

import model.Product;
import service.ProductService;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BrowseProductsFrame extends JFrame {

    private ProductService productService;
    private JTextArea productArea;

    public BrowseProductsFrame(ProductService productService) {

        this.productService = productService;

        setTitle("VIT Campus Marketplace - Browse Products");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        createScreen();
        displayProducts();
    }

    private void createScreen() {

        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel(
                "AVAILABLE PRODUCTS",
                SwingConstants.CENTER
        );

        titleLabel.setFont(
                new Font("Arial", Font.BOLD, 22)
        );

        add(titleLabel, BorderLayout.NORTH);

        productArea = new JTextArea();
        productArea.setEditable(false);

        JScrollPane scrollPane =
                new JScrollPane(productArea);

        add(scrollPane, BorderLayout.CENTER);

        JButton refreshButton =
                new JButton("Refresh");

        refreshButton.addActionListener(e ->
                displayProducts()
        );

        add(refreshButton, BorderLayout.SOUTH);
    }

    private void displayProducts() {

        productArea.setText("");

        ArrayList<Product> products =
                productService.getProducts();

        if (products.isEmpty()) {

            productArea.setText(
                    "No products available."
            );

            return;
        }

        for (Product product : products) {

            productArea.append(
                    "================================\n"
            );

            productArea.append(
                    "Product ID: "
                    + product.getProductId()
                    + "\n"
            );

            productArea.append(
                    "Name: "
                    + product.getName()
                    + "\n"
            );

            productArea.append(
                    "Category: "
                    + product.getCategory()
                    + "\n"
            );

            productArea.append(
                    "Description: "
                    + product.getDescription()
                    + "\n"
            );

            productArea.append(
                    "Price: Rs. "
                    + product.getPrice()
                    + "\n"
            );

            productArea.append(
                    "Status: "
                    + product.getStatus()
                    + "\n"
            );

            productArea.append(
                    "================================\n\n"
            );
        }
    }
}