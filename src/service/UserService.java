package service;

import model.User;
import java.util.ArrayList;

public class UserService {

    private ArrayList<User> users = new ArrayList<>();
    private ActivityLogger logger = new ActivityLogger();

    // Add user
    public void addUser(User user) {

        users.add(user);

        System.out.println("User registered successfully.");
        System.out.println("Name: " + user.getName());
        System.out.println("Email: " + user.getEmail());

        logger.logActivity(
                "New user registered: " + user.getEmail()
        );
    }

    // Display all users
    public void displayAllUsers() {

        System.out.println("\n===== ALL USERS =====");

        for (User user : users) {

            System.out.println("User ID: "
                    + user.getUserId());

            System.out.println("Name: "
                    + user.getName());

            System.out.println("Email: "
                    + user.getEmail());

            System.out.println("Role: "
                    + user.getRole());

            System.out.println("------------------------");
        }
    }

    // Search user by email
    public User searchUserByEmail(String email) {

        for (User user : users) {

            if (user.getEmail().equalsIgnoreCase(email)) {

                logger.logActivity(
                        "User searched: " + email
                );

                return user;
            }
        }

        return null;
    }

    // Get all users
    public ArrayList<User> getUsers() {

        return users;
    }
}