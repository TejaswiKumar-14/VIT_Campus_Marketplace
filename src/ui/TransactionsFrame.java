package ui;

import model.Product;
import model.Transaction;
import service.ProductService;
import service.TransactionService;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TransactionsFrame extends JFrame {

    private ProductService productService;
    private TransactionService transactionService;

    private JTextField productIdField;
    private JTextField sellerIdField;

    private JTextArea transactionArea;

    private int currentUserId;

    public TransactionsFrame(
            ProductService productService,
            TransactionService transactionService,
            int currentUserId) {

        this.productService = productService;
        this.transactionService =
                transactionService;
        this.currentUserId = currentUserId;

        setTitle(
                "VIT Campus Marketplace - Transactions"
        );

        setSize(600, 500);

        setDefaultCloseOperation(
                JFrame.DISPOSE_ON_CLOSE
        );

        setLocationRelativeTo(null);

        createScreen();
    }

    private void createScreen() {

        setLayout(new BorderLayout());

        // Title
        JLabel titleLabel = new JLabel(
                "TRANSACTIONS",
                SwingConstants.CENTER
        );

        titleLabel.setFont(
                new Font("Arial", Font.BOLD, 22)
        );

        add(titleLabel, BorderLayout.NORTH);

        // Input panel
        JPanel inputPanel = new JPanel(
                new GridLayout(3, 2, 10, 10)
        );

        productIdField = new JTextField();
        sellerIdField = new JTextField();

        JButton buyButton =
                new JButton("Create Transaction");

        JButton viewButton =
                new JButton("View Transactions");

        inputPanel.add(
                new JLabel("Product ID:")
        );

        inputPanel.add(productIdField);

        inputPanel.add(
                new JLabel("Seller ID:")
        );

        inputPanel.add(sellerIdField);

        inputPanel.add(buyButton);
        inputPanel.add(viewButton);

        add(inputPanel, BorderLayout.CENTER);

        // Transaction area
        transactionArea = new JTextArea();

        transactionArea.setEditable(false);

        transactionArea.setLineWrap(true);

        transactionArea.setWrapStyleWord(true);

        JScrollPane scrollPane =
                new JScrollPane(transactionArea);

        scrollPane.setPreferredSize(
                new Dimension(600, 280)
        );

        add(scrollPane, BorderLayout.SOUTH);

        // Create transaction
        buyButton.addActionListener(e ->
                createTransaction()
        );

        // View transactions
        viewButton.addActionListener(e ->
                viewTransactions()
        );
    }

    private void createTransaction() {

        String productText =
                productIdField.getText().trim();

        String sellerText =
                sellerIdField.getText().trim();

        if (productText.isEmpty()
                || sellerText.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please fill all fields."
            );

            return;
        }

        int productId;
        int sellerId;

        try {

            productId =
                    Integer.parseInt(productText);

            sellerId =
                    Integer.parseInt(sellerText);

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter valid numeric IDs."
            );

            return;
        }

        // Check that buyer is not the seller
        if (currentUserId == sellerId) {

            JOptionPane.showMessageDialog(
                    this,
                    "You cannot buy your own product."
            );

            return;
        }

        // Find product
        Product selectedProduct = null;

        ArrayList<Product> products =
                productService.getProducts();

        for (Product product : products) {

            if (product.getProductId()
                    == productId) {

                selectedProduct = product;

                break;
            }
        }

        if (selectedProduct == null) {

            JOptionPane.showMessageDialog(
                    this,
                    "Product not found."
            );

            return;
        }

        // Check product seller
        if (selectedProduct.getSellerId()
                != sellerId) {

            JOptionPane.showMessageDialog(
                    this,
                    "Seller ID does not match the product."
            );

            return;
        }

        // Check product status
        if (!selectedProduct.getStatus()
                .equalsIgnoreCase("Available")) {

            JOptionPane.showMessageDialog(
                    this,
                    "This product is not available."
            );

            return;
        }

        // Create transaction
        int transactionId =
                (int) (Math.random() * 10000);

        Transaction transaction =
                new Transaction(
                        transactionId,
                        productId,
                        currentUserId,
                        sellerId,
                        "Completed"
                );

        transactionService.addTransaction(
                transaction
        );

        // Mark product as sold
        productService.markAsSold(
                selectedProduct
        );

        JOptionPane.showMessageDialog(
                this,
                "Transaction completed successfully!"
        );

        productIdField.setText("");
        sellerIdField.setText("");
    }

    private void viewTransactions() {

        transactionArea.setText("");

        ArrayList<Transaction> transactions =
                transactionService.getTransactions();

        if (transactions.isEmpty()) {

            transactionArea.setText(
                    "No transactions available."
            );

            return;
        }

        transactionArea.append(
                "===== TRANSACTIONS =====\n\n"
        );

        for (Transaction transaction :
                transactions) {

            transactionArea.append(
                    "Transaction ID: "
                    + transaction.getTransactionId()
                    + "\n"
            );

            transactionArea.append(
                    "Product ID: "
                    + transaction.getProductId()
                    + "\n"
            );

            transactionArea.append(
                    "Buyer ID: "
                    + transaction.getBuyerId()
                    + "\n"
            );

            transactionArea.append(
                    "Seller ID: "
                    + transaction.getSellerId()
                    + "\n"
            );

            transactionArea.append(
                    "Status: "
                    + transaction.getStatus()
                    + "\n"
            );

            transactionArea.append(
                    "-----------------------------\n"
            );
        }
    }
}