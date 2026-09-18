package ui;

import model.Book;
import model.Bicycle;
import model.Electronics;
import model.Product;
import service.ProductService;
import exception.InvalidProductException;

import javax.swing.*;
import java.awt.*;

public class AddProductFrame extends JFrame {

    private ProductService productService;

    private JTextField nameField;
    private JTextField descriptionField;
    private JTextField priceField;
    private JTextField extraField;

    private JComboBox<String> categoryBox;
    private JLabel extraLabel;

    private int sellerId;

    public AddProductFrame(ProductService productService,
                           int sellerId) {

        this.productService = productService;
        this.sellerId = sellerId;

        setTitle("VIT Campus Marketplace - Add Product");
        setSize(500, 450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        createForm();
    }

    private void createForm() {

        JPanel panel = new JPanel(
                new GridLayout(7, 2, 10, 10)
        );

        JLabel titleLabel = new JLabel(
                "ADD NEW PRODUCT",
                SwingConstants.CENTER
        );

        nameField = new JTextField();

        descriptionField = new JTextField();

        priceField = new JTextField();

        categoryBox = new JComboBox<>(
                new String[]{
                    "Books",
                    "Bicycles",
                    "Electronics"
                }
        );

        extraLabel = new JLabel("Author:");

        extraField = new JTextField();

        JButton addButton =
                new JButton("Add Product");

        JButton clearButton =
                new JButton("Clear");

        panel.add(new JLabel("Product Name:"));
        panel.add(nameField);

        panel.add(new JLabel("Category:"));
        panel.add(categoryBox);

        panel.add(new JLabel("Description:"));
        panel.add(descriptionField);

        panel.add(new JLabel("Price:"));
        panel.add(priceField);

        panel.add(extraLabel);
        panel.add(extraField);

        panel.add(addButton);
        panel.add(clearButton);

        add(titleLabel, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);

        categoryBox.addActionListener(e ->
                updateExtraField()
        );

        addButton.addActionListener(e ->
                addProduct()
        );

        clearButton.addActionListener(e ->
                clearFields()
        );
    }

    private void updateExtraField() {

        String category =
                (String) categoryBox.getSelectedItem();

        if (category.equals("Books")) {

            extraLabel.setText("Author:");

        } else if (category.equals("Bicycles")) {

            extraLabel.setText("Condition:");

        } else {

            extraLabel.setText("Brand:");
        }
    }

    private void addProduct() {

        String name =
                nameField.getText().trim();

        String category =
                (String) categoryBox.getSelectedItem();

        String description =
                descriptionField.getText().trim();

        String priceText =
                priceField.getText().trim();

        String extra =
                extraField.getText().trim();

        if (name.isEmpty()
                || description.isEmpty()
                || priceText.isEmpty()
                || extra.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please fill all fields."
            );

            return;
        }

        double price;

        try {

            price = Double.parseDouble(priceText);

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter a valid price."
            );

            return;
        }

        Product product;

        if (category.equals("Books")) {

            product = new Book(
                    101,
                    sellerId,
                    name,
                    description,
                    price,
                    "Available",
                    extra
            );

        } else if (category.equals("Bicycles")) {

            product = new Bicycle(
                    102,
                    sellerId,
                    name,
                    description,
                    price,
                    "Available",
                    extra
            );

        } else {

            product = new Electronics(
                    103,
                    sellerId,
                    name,
                    description,
                    price,
                    "Available",
                    extra
            );
        }

        try {

            productService.validateProduct(product);

            productService.addProduct(product);

            JOptionPane.showMessageDialog(
                    this,
                    "Product added successfully!"
            );

            clearFields();

        } catch (InvalidProductException e) {

            JOptionPane.showMessageDialog(
                    this,
                    e.getMessage(),
                    "Invalid Product",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void clearFields() {

        nameField.setText("");
        descriptionField.setText("");
        priceField.setText("");
        extraField.setText("");

        categoryBox.setSelectedIndex(0);
    }
}