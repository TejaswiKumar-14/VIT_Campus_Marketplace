package ui;

import model.Product;
import service.ProductService;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SearchProductsFrame extends JFrame {

    private ProductService productService;

    private JTextField searchField;
    private JTextField priceField;

    private JComboBox<String> categoryBox;

    private JTextArea resultArea;

    public SearchProductsFrame(ProductService productService) {

        this.productService = productService;

        setTitle("VIT Campus Marketplace - Search Products");
        setSize(650, 550);

        setDefaultCloseOperation(
                JFrame.DISPOSE_ON_CLOSE
        );

        setLocationRelativeTo(null);

        createScreen();
    }

    private void createScreen() {

        setLayout(new BorderLayout());

        // ---------------- TITLE ----------------

        JLabel titleLabel = new JLabel(
                "SEARCH PRODUCTS",
                SwingConstants.CENTER
        );

        titleLabel.setFont(
                new Font("Arial", Font.BOLD, 22)
        );

        add(titleLabel, BorderLayout.NORTH);

        // ---------------- INPUT PANEL ----------------

        JPanel inputPanel = new JPanel();

        inputPanel.setLayout(
                new GridLayout(4, 2, 10, 10)
        );

        // Product name
        searchField = new JTextField();

        // Category
        categoryBox = new JComboBox<>(
                new String[]{
                    "All",
                    "Books",
                    "Bicycles",
                    "Electronics"
                }
        );

        // Maximum price
        priceField = new JTextField();

        JButton searchButton =
                new JButton("Search");

        JButton budgetButton =
                new JButton("Search by Budget");

        inputPanel.add(
                new JLabel("Product Name:")
        );

        inputPanel.add(searchField);

        inputPanel.add(
                new JLabel("Category:")
        );

        inputPanel.add(categoryBox);

        inputPanel.add(
                new JLabel("Maximum Price:")
        );

        inputPanel.add(priceField);

        inputPanel.add(searchButton);

        inputPanel.add(budgetButton);

        add(inputPanel, BorderLayout.CENTER);

        // ---------------- RESULT AREA ----------------

        resultArea = new JTextArea();

        resultArea.setEditable(false);

        resultArea.setLineWrap(true);

        resultArea.setWrapStyleWord(true);

        JScrollPane scrollPane =
                new JScrollPane(resultArea);

        add(scrollPane, BorderLayout.SOUTH);

        scrollPane.setPreferredSize(
                new Dimension(650, 300)
        );

        // ---------------- BUTTON ACTIONS ----------------

        searchButton.addActionListener(e ->
                searchProducts()
        );

        budgetButton.addActionListener(e ->
                searchByBudget()
        );
    }

    // =====================================================
    // SEARCH PRODUCTS
    // =====================================================

    private void searchProducts() {

        String keyword =
                searchField.getText()
                        .trim()
                        .toLowerCase();

        String category =
                (String) categoryBox.getSelectedItem();

        ArrayList<Product> products =
                productService.getProducts();

        resultArea.setText("");

        boolean found = false;

        for (Product product : products) {

            boolean nameMatch;

            if (keyword.isEmpty()) {

                nameMatch = true;

            } else {

                nameMatch =
                        product.getName()
                                .toLowerCase()
                                .contains(keyword);
            }

            boolean categoryMatch;

            if (category.equals("All")) {

                categoryMatch = true;

            } else {

                categoryMatch =
                        product.getCategory()
                                .equalsIgnoreCase(category);
            }

            if (nameMatch && categoryMatch) {

                displayProduct(product);

                found = true;
            }
        }

        if (!found) {

            resultArea.setText(
                    "No matching products found."
            );
        }
    }

    // =====================================================
    // SEARCH BY BUDGET
    // =====================================================

    private void searchByBudget() {

        String priceText =
                priceField.getText().trim();

        if (priceText.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter maximum price."
            );

            return;
        }

        double maxPrice;

        try {

            maxPrice =
                    Double.parseDouble(priceText);

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter a valid price."
            );

            return;
        }

        if (maxPrice <= 0) {

            JOptionPane.showMessageDialog(
                    this,
                    "Price must be greater than zero."
            );

            return;
        }

        ArrayList<Product> products =
                productService.getProducts();

        resultArea.setText("");

        boolean found = false;

        for (Product product : products) {

            if (product.getPrice() <= maxPrice) {

                displayProduct(product);

                found = true;
            }
        }

        if (!found) {

            resultArea.setText(
                    "No products found within this budget."
            );
        }
    }

    // =====================================================
    // DISPLAY PRODUCT
    // =====================================================

    private void displayProduct(Product product) {

        resultArea.append(
                "====================================\n"
        );

        resultArea.append(
                "Product ID: "
                + product.getProductId()
                + "\n"
        );

        resultArea.append(
                "Name: "
                + product.getName()
                + "\n"
        );

        resultArea.append(
                "Category: "
                + product.getCategory()
                + "\n"
        );

        resultArea.append(
                "Description: "
                + product.getDescription()
                + "\n"
        );

        resultArea.append(
                "Price: Rs. "
                + product.getPrice()
                + "\n"
        );

        resultArea.append(
                "Status: "
                + product.getStatus()
                + "\n"
        );

        resultArea.append(
                "Seller ID: "
                + product.getSellerId()
                + "\n"
        );

        resultArea.append(
                "====================================\n\n"
        );
    }
}