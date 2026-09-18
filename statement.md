# VIT Campus Marketplace - Project Statement

## 1. Project Title

VIT Campus Marketplace

## 2. Course

Programming in Java

## 3. Institution

VIT Bhopal University

## 4. Project Type

Java Desktop Application

## 5. Problem Statement

Students often need to buy or sell used items within the campus, such as books, bicycles, and electronic devices.

There is a need for a simple platform where students can list products for sale, browse available products, search for required items, communicate with other students, and manage basic transactions.

VIT Campus Marketplace is designed to provide a simple campus-level solution for these requirements.

## 6. Project Scope

The project focuses on providing basic buying and selling functionality for students within a campus environment.

The current scope includes:

- User login
- Product listing
- Product browsing
- Product searching
- Category-based search
- Budget-based search
- Messaging
- Basic transactions
- User profile
- Activity logging

The current version is a Java desktop application and uses temporary in-memory storage through Java ArrayList.

## 7. Target Users

The target users are:

- VIT Bhopal students
- Students who want to sell used items
- Students who want to purchase campus items

## 8. Objectives

The objectives of the project are:

1. To provide a simple campus marketplace.
2. To allow students to list products for sale.
3. To allow students to browse available products.
4. To provide product searching functionality.
5. To provide category and budget-based filtering.
6. To provide basic communication between users.
7. To provide basic transaction management.
8. To demonstrate Java programming concepts through a practical project.

## 9. High-Level Features

### User Management

- User login
- Demo student account
- User profile
- Logout

### Product Management

- Add products
- View products
- Product categories
- Product validation
- Product status

### Search

- Search by product name
- Search by category
- Search by maximum price

### Messaging

- Send messages
- View received messages

### Transactions

- Create transaction
- Verify product availability
- Verify seller ID
- Mark product as sold

### Activity Logging

Important activities are recorded in a text file named:

marketplace_log.txt

## 10. Technologies Used

- Java
- Java Swing
- NetBeans IDE
- ArrayList
- File Handling
- Exception Handling
- Multithreading

## 11. Java Concepts Implemented

The project demonstrates:

- Classes and Objects
- Encapsulation
- Inheritance
- Polymorphism
- Interfaces
- Exception Handling
- Collections
- File Handling
- Multithreading
- Java Swing GUI

## 12. Product Hierarchy

The project uses inheritance for different product categories.

Product hierarchy:

Product
├── Book
├── Bicycle
└── Electronics

## 13. User Hierarchy

The project uses inheritance for different types of users.

User hierarchy:

User
├── Student
└── Admin

## 14. Storage Approach

The current version uses Java ArrayList for temporary in-memory storage.

The following information is stored during the application session:

- Users
- Products
- Messages
- Transactions

Activity information is stored in:

marketplace_log.txt

The current version does not use MySQL.

## 15. Expected Outcome

The expected outcome is a functional Java desktop application that allows students to:

- Log in
- Add products
- Browse products
- Search products
- Find products within a budget
- Send messages
- Create basic transactions
- View their profile
- Log out

## 16. Limitations

The current version has the following limitations:

- Data stored in ArrayList is temporary.
- Data is cleared when the application is closed.
- The application is designed for desktop use.
- Online payment is not implemented.
- Product images are not currently supported.
- Real-time notifications are not implemented.

## 17. Future Enhancements

Future versions can include:

- MySQL database integration
- Permanent data storage
- Product image upload
- Real-time messaging
- Product ratings and reviews
- Online payment integration
- Advanced search and filtering
- Admin dashboard
- Email notifications
- Mobile application

## 18. Conclusion

VIT Campus Marketplace provides a simple Java-based solution for buying and selling items within a campus environment.

The project combines Java Swing with important Java programming concepts to create a practical desktop application.
