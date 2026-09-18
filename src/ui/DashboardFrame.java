package ui;

import model.User;
import service.UserService;
import service.ProductService;
import service.MessageService;
import service.TransactionService;

import javax.swing.*;
import java.awt.*;

public class DashboardFrame extends JFrame {

    private UserService userService;
    private User currentUser;

    private ProductService productService;
    private MessageService messageService;
    private TransactionService transactionService;

    public DashboardFrame(UserService userService,
                          User currentUser) {

        this.userService = userService;
        this.currentUser = currentUser;

        // Create services
        productService = new ProductService();
        messageService = new MessageService();
        transactionService = new TransactionService();

        setTitle("VIT Campus Marketplace - Dashboard");
        setSize(600, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        createDashboard();
    }

    private void createDashboard() {

        setLayout(new BorderLayout());

        // ---------------- TITLE ----------------

        JLabel titleLabel = new JLabel(
                "VIT CAMPUS MARKETPLACE",
                SwingConstants.CENTER
        );

        titleLabel.setFont(
                new Font("Arial", Font.BOLD, 22)
        );

        add(titleLabel, BorderLayout.NORTH);

        // ---------------- BUTTON PANEL ----------------

        JPanel panel = new JPanel();

        panel.setLayout(
                new GridLayout(4, 2, 15, 15)
        );

        JButton addProductButton =
                new JButton("Add Product");

        JButton browseButton =
                new JButton("Browse Products");

        JButton searchButton =
                new JButton("Search Products");

        JButton messageButton =
                new JButton("Messages");

        JButton transactionButton =
                new JButton("Transactions");

        JButton profileButton =
                new JButton("My Profile");

        JButton logoutButton =
                new JButton("Logout");

        panel.add(addProductButton);
        panel.add(browseButton);
        panel.add(searchButton);
        panel.add(messageButton);
        panel.add(transactionButton);
        panel.add(profileButton);
        panel.add(logoutButton);

        add(panel, BorderLayout.CENTER);

        // ---------------- USER INFORMATION ----------------

        JLabel userLabel = new JLabel(
                "Logged in as: "
                + currentUser.getName()
                + " | "
                + currentUser.getEmail(),
                SwingConstants.CENTER
        );

        add(userLabel, BorderLayout.SOUTH);

        // ---------------- BUTTON ACTIONS ----------------

        addProductButton.addActionListener(e -> {

            openAddProduct();

        });

        browseButton.addActionListener(e -> {

            openBrowseProducts();

        });

        searchButton.addActionListener(e -> {

            openSearchProducts();

        });

        messageButton.addActionListener(e -> {

            openMessages();

        });

        transactionButton.addActionListener(e -> {

            openTransactions();

        });

        profileButton.addActionListener(e -> {

            showProfile();

        });

        logoutButton.addActionListener(e -> {

            logout();

        });
    }

    // =====================================================
    // ADD PRODUCT
    // =====================================================

    private void openAddProduct() {

        AddProductFrame frame =
                new AddProductFrame(
                        productService,
                        currentUser.getUserId()
                );

        frame.setVisible(true);
    }

    // =====================================================
    // BROWSE PRODUCTS
    // =====================================================

    private void openBrowseProducts() {

        BrowseProductsFrame frame =
                new BrowseProductsFrame(
                        productService
                );

        frame.setVisible(true);
    }

    // =====================================================
    // SEARCH PRODUCTS
    // =====================================================

    private void openSearchProducts() {

        SearchProductsFrame frame =
                new SearchProductsFrame(
                        productService
                );

        frame.setVisible(true);
    }

    // =====================================================
    // MESSAGES
    // =====================================================

    private void openMessages() {

        MessagesFrame frame =
                new MessagesFrame(
                        messageService,
                        currentUser.getUserId()
                );

        frame.setVisible(true);
    }

    // =====================================================
    // TRANSACTIONS
    // =====================================================

    private void openTransactions() {

        TransactionsFrame frame =
                new TransactionsFrame(
                        productService,
                        transactionService,
                        currentUser.getUserId()
                );

        frame.setVisible(true);
    }

    // =====================================================
    // PROFILE
    // =====================================================

    private void showProfile() {

        JOptionPane.showMessageDialog(
                this,

                "Name: "
                + currentUser.getName()
                + "\nEmail: "
                + currentUser.getEmail()
                + "\nRole: "
                + currentUser.getRole(),

                "My Profile",

                JOptionPane.INFORMATION_MESSAGE
        );
    }

    // =====================================================
    // LOGOUT
    // =====================================================

    private void logout() {

        int choice =
                JOptionPane.showConfirmDialog(
                        this,
                        "Do you want to logout?",
                        "Logout",
                        JOptionPane.YES_NO_OPTION
                );

        if (choice == JOptionPane.YES_OPTION) {

            dispose();

            LoginFrame loginFrame =
                    new LoginFrame(userService);

            loginFrame.setVisible(true);
        }
    }
}