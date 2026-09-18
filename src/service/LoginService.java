package service;

import model.User;
import java.util.ArrayList;

public class LoginService {

    private ArrayList<User> users;
    private ActivityLogger logger = new ActivityLogger();

    public LoginService(ArrayList<User> users) {
        this.users = users;
    }

    // Login user
    public User login(String email, String password) {

        for (User user : users) {

            if (user.getEmail().equalsIgnoreCase(email)
                    && user.getPassword().equals(password)) {

                System.out.println("Login successful!");

                logger.logActivity(
                        "Successful login: " + email
                );

                return user;
            }
        }

        System.out.println("Invalid email or password.");

        logger.logActivity(
                "Failed login attempt: " + email
        );

        return null;
    }
}