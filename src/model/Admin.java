/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author kumar
 */
package model;

public class Admin extends User {

    public Admin(int userId, String name, String email, String password) {

        super(userId, name, email, password, "Admin");
    }
}
