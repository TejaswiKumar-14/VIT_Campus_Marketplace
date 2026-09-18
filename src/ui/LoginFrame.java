package ui;

import model.Student;
import model.User;
import service.LoginService;
import service.UserService;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {

    private JTextField emailField;
    private JPasswordField passwordField;

    private UserService userService;
    private LoginService loginService;

    public LoginFrame(UserService userService) {

        this.userService = userService;
        this.loginService = new LoginService(userService.getUsers());

        setTitle("VIT Campus Marketplace - Login");
        setSize(450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        createLoginScreen();
    }

    private void createLoginScreen() {

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1, 10, 10));

        JLabel titleLabel =
                new JLabel("VIT CAMPUS MARKETPLACE",
                        SwingConstants.CENTER);

        JLabel emailLabel =
                new JLabel("Email:");

        emailField = new JTextField();

        JLabel passwordLabel =
                new JLabel("Password:");

        passwordField = new JPasswordField();

        JButton loginButton =
                new JButton("Login");

        JButton registerButton =
                new JButton("Demo Student Login");

        panel.add(titleLabel);
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(passwordLabel);
        panel.add(passwordField);

        JPanel buttonPanel = new JPanel();

        buttonPanel.add(loginButton);
        buttonPanel.add(registerButton);

        add(panel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        loginButton.addActionListener(e -> login());

        registerButton.addActionListener(e -> createDemoStudent());
    }

    private void createDemoStudent() {

        if (userService.getUsers().isEmpty()) {

            Student student = new Student(
                    1,
                    "Student One",
                    "student@vitbhopal.ac.in",
                    "12345",
                    "25BAI00000"
            );

            userService.addUser(student);

            emailField.setText(
                    "student@vitbhopal.ac.in"
            );

            passwordField.setText("12345");

            JOptionPane.showMessageDialog(
                    this,
                    "Demo student created.\n" +
                    "Click Login."
            );

        } else {

            JOptionPane.showMessageDialog(
                    this,
                    "Demo student already exists."
            );
        }
    }

    private void login() {

        String email = emailField.getText();

        String password =
                new String(passwordField.getPassword());

        if (email.isEmpty() || password.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter email and password."
            );

            return;
        }

        User user =
                loginService.login(email, password);

        if (user != null) {

            JOptionPane.showMessageDialog(
                    this,
                    "Login successful!\nWelcome "
                    + user.getName()
            );

            dispose();

            new DashboardFrame(
                    userService,
                    user
            ).setVisible(true);

        } else {

            JOptionPane.showMessageDialog(
                    this,
                    "Invalid email or password."
            );
        }
    }
}