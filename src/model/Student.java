/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author kumar
 */
package model;

public class Student extends User {

    private String registrationNumber;

    public Student(int userId, String name, String email,
                   String password, String registrationNumber) {

        super(userId, name, email, password, "Student");
        this.registrationNumber = registrationNumber;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }
}
