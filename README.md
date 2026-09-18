# VIT Campus Marketplace

## Project Overview

VIT Campus Marketplace is a Java-based desktop application designed for students of VIT Bhopal University.

The application provides a simple platform for students to buy and sell useful campus items such as books, bicycles, and electronics.

The project is developed using Java Swing and demonstrates various concepts from the Programming in Java course.

## Problem Statement

Students often need to buy or sell used items within the campus, such as textbooks, bicycles, and electronic devices.

There is a need for a simple platform where students can list products, browse available products, search for items, communicate with other users, and manage basic transactions.

VIT Campus Marketplace provides a simple campus-level solution for these requirements.

## Objectives

- To create a simple marketplace for VIT Bhopal students.
- To allow students to add products for sale.
- To allow users to browse available products.
- To provide product search functionality.
- To provide category-based searching.
- To provide budget-based product searching.
- To provide a basic messaging system.
- To provide a basic transaction system.
- To demonstrate Java programming concepts through a practical application.

## Target Users

- VIT Bhopal students
- Student sellers
- Student buyers

## Features

### 1. User Login

Users can log in using their email and password.

A demo student account is provided for testing.

### 2. Dashboard

After successful login, users can access:

- Add Product
- Browse Products
- Search Products
- Messages
- Transactions
- My Profile
- Logout

### 3. Add Product

Users can add products from the following categories:

- Books
- Bicycles
- Electronics

Product information includes:

- Product Name
- Category
- Description
- Price
- Author for Books
- Condition for Bicycles
- Brand for Electronics

### 4. Browse Products

Users can view products available in the marketplace.

The application displays:

- Product ID
- Product Name
- Category
- Description
- Price
- Status
- Seller ID

### 5. Search Products

Users can search products using:

- Product Name
- Category

Available categories are:

- All
- Books
- Bicycles
- Electronics

### 6. Search by Budget

Users can enter a maximum price and find products within their budget.

For example:

Maximum Price: 500

The application displays products costing Rs. 500 or less.

### 7. Messaging

Users can send messages to other users using their User ID.

Users can also view messages received by their account.

### 8. Transactions

Users can create a transaction for an available product.

The application checks:

- Product ID
- Seller ID
- Product availability
- Buyer and seller IDs

After a successful transaction, the product status changes from:

Available → Sold

### 9. My Profile

Users can view their:

- Name
- Email
- Role

### 10. Logout

Users can log out of the application and return to the login screen.

### 11. Activity Logging

Important application activities are recorded in:

marketplace_log.txt

## Technologies Used

- Java
- Java Swing
- NetBeans IDE
- Java Collections
- File Handling
- Exception Handling
- Multithreading

## Java Concepts Used

### Classes and Objects

Classes and objects are used to represent users, products, messages, and transactions.

Examples:

- User
- Product
- Message
- Transaction

### Inheritance

Inheritance is used in the user and product models.

User hierarchy:

User
├── Student
└── Admin

Product hierarchy:

Product
├── Book
├── Bicycle
└── Electronics

### Polymorphism

Different product types are handled using the common Product reference.

For example:

Product product;

The reference can represent a:

- Book
- Bicycle
- Electronics

object.

### Interface

The ProductOperations interface defines product-related operations such as:

- Add Product
- Display Product
- Mark Product as Sold
- Validate Product
- Search Product
- Filter by Price
- Search by Category

### Exception Handling

A custom exception called InvalidProductException is used to handle invalid product information such as:

- Empty product name
- Invalid price

### ArrayList

ArrayList is used for temporary in-memory storage of:

- Users
- Products
- Messages
- Transactions

### File Handling

The ActivityLogger class uses Java file handling to store important application activities in:

marketplace_log.txt

### Multithreading

The MarketplaceThread class extends the Java Thread class and demonstrates basic multithreading.

### Java Swing

Java Swing is used to create the graphical user interface.

The application contains multiple frames:

- LoginFrame
- DashboardFrame
- AddProductFrame
- BrowseProductsFrame
- SearchProductsFrame
- MessagesFrame
- TransactionsFrame

## Project Architecture

The project follows a simple layered structure:

Java Swing UI
        |
        v
Service / Business Layer
        |
        +-------------------+
        |          |        |
        v          v        v
      Users     Products  Messages
                    |
                    v
               Transactions
                    |
                    v
              Activity Logger
                    |
                    v
           marketplace_log.txt

## Project Structure

VIT_Campus_Marketplace
│
├── src
│   │
│   ├── model
│   │   ├── User.java
│   │   ├── Student.java
│   │   ├── Admin.java
│   │   ├── Product.java
│   │   ├── Book.java
│   │   ├── Bicycle.java
│   │   ├── Electronics.java
│   │   ├── Message.java
│   │   └── Transaction.java
│   │
│   ├── service
│   │   ├── UserService.java
│   │   ├── LoginService.java
│   │   ├── ProductService.java
│   │   ├── ProductOperations.java
│   │   ├── MessageService.java
│   │   ├── TransactionService.java
│   │   └── ActivityLogger.java
│   │
│   ├── exception
│   │   └── InvalidProductException.java
│   │
│   ├── thread
│   │   └── MarketplaceThread.java
│   │
│   ├── ui
│   │   ├── LoginFrame.java
│   │   ├── DashboardFrame.java
│   │   ├── AddProductFrame.java
│   │   ├── BrowseProductsFrame.java
│   │   ├── SearchProductsFrame.java
│   │   ├── MessagesFrame.java
│   │   └── TransactionsFrame.java
│   │
│   └── database
│       └── DBConnection.java
│
├── screenshots
├── README.md
└── statement.md

## Application Workflow

Start Application
        |
        v
      Login
        |
        v
    Dashboard
        |
        +-------------------+
        |                   |
        v                   v
   Add Product        Browse Products
                            |
                            v
                     Search Products
                            |
                 +----------+----------+
                 |                     |
                 v                     v
          Search by Name       Search by Budget
                 |
                 v
             Messages
                 |
                 v
           Transactions
                 |
                 v
        Product Status
        Available → Sold

## Installation and Setup

### Requirements

- Java JDK
- NetBeans IDE
- Computer capable of running Java Swing applications

### Steps

1. Download or clone the project from GitHub.
2. Open NetBeans IDE.
3. Select File → Open Project.
4. Select the VIT_Campus_Marketplace project folder.
5. Build the project.
6. Run the project.

## How to Run

The main class of the project is:

Main.java

Run Main.java to start the application.

The login window will appear.

## Demo Login

Use the following demo credentials:

Email:
student@vitbhopal.ac.in

Password:
12345

Demo student information:

User ID:
1

Name:
Student One

Registration Number:
25BAI00000

Role:
Student

The Demo Student Login button can also be used from the login screen.

## Testing

The following major features have been tested:

| Feature | Result |
|---|---|
| Application Startup | Passed |
| Demo Student Creation | Passed |
| User Login | Passed |
| Dashboard | Passed |
| Add Product | Passed |
| Browse Products | Passed |
| Search by Product Name | Passed |
| Search by Category | Passed |
| Search by Budget | Passed |
| Send Message | Passed |
| View Messages | Passed |
| Create Transaction | Passed |
| Mark Product as Sold | Passed |
| My Profile | Passed |
| Logout | Passed |

## Validation and Error Handling

The application provides basic validation and error handling.

Examples include:

- Empty field validation
- Invalid price validation
- Invalid User ID validation
- Invalid Product ID validation
- Seller ID verification
- Product availability checking
- Prevention of buying your own product
- Custom InvalidProductException

## Data Storage

The current version uses Java ArrayList for temporary in-memory storage.

The following data is stored during the current application session:

- Users
- Products
- Messages
- Transactions

The application also uses a text file for activity logging:

marketplace_log.txt

### Note

The current version does not use MySQL for data storage.

Products, messages, and transactions stored in ArrayList are cleared when the application is closed.

## Non-Functional Requirements

### Usability

The application provides a simple graphical user interface using Java Swing.

### Performance

ArrayList provides simple and efficient access to temporary application data during a session.

### Reliability

Input validation and exception handling are used to reduce application errors.

### Maintainability

The project is divided into separate packages for:

- Models
- Services
- User Interface
- Exceptions
- Threads
- Database

### Error Handling

The application displays appropriate messages when users enter invalid or incomplete information.

## Limitations

The current version has the following limitations:

1. Data is stored temporarily using ArrayList.
2. Product, message, and transaction data is cleared when the application is closed.
3. The application is designed as a desktop application.
4. Online payment functionality is not included.
5. Product image upload is not currently supported.
6. Real-time notifications are not included.
7. The messaging system is a basic session-based implementation.

## Future Enhancements

Future versions of the project can include:

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

## Screenshots

Screenshots of the working application will be added to the screenshots folder.

Suggested screenshots include:

1. Login Screen
2. Dashboard
3. Add Product
4. Browse Products
5. Search Products
6. Messages
7. Transactions
8. My Profile

Example:

![Login Screen](screenshots/login.png)

![Dashboard](screenshots/dashboard.png)

![Add Product](screenshots/add_product.png)

![Browse Products](screenshots/browse_products.png)

![Search Products](screenshots/search_products.png)

![Messages](screenshots/messages.png)

![Transactions](screenshots/transactions.png)

## Course Information

Project Name: VIT Campus Marketplace

Course: Programming in Java

Institution: VIT Bhopal University

Project Type: Java Desktop Application

Development Environment: NetBeans IDE

## Conclusion

VIT Campus Marketplace is a practical Java desktop application designed to provide a simple buying and selling platform for students within the campus.

The project demonstrates important Java concepts including object-oriented programming, inheritance, polymorphism, interfaces, exception handling, collections, file handling, multithreading, and Java Swing.

The current application provides basic functionality for listing, browsing, searching, messaging, and transacting campus products.
