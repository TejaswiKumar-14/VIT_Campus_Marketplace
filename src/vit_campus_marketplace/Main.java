package vit_campus_marketplace;

import model.Student;
import service.UserService;
import ui.LoginFrame;

public class Main {

    public static void main(String[] args) {

        // Create UserService
        UserService userService =
                new UserService();

        // Create a demo student
        Student student = new Student(
                1,
                "Student One",
                "student@vitbhopal.ac.in",
                "12345",
                "25BAI00000"
        );

        // Add student to UserService
        userService.addUser(student);

        // Open Login Window
        LoginFrame loginFrame =
                new LoginFrame(userService);

        loginFrame.setVisible(true);
    }
}