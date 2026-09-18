package service;

import model.Transaction;
import java.util.ArrayList;

public class TransactionService {

    private ArrayList<Transaction> transactions =
            new ArrayList<>();

    private ActivityLogger logger =
            new ActivityLogger();

    public void addTransaction(
            Transaction transaction) {

        transactions.add(transaction);

        System.out.println(
                "Transaction created successfully."
        );

        logger.logActivity(
                "Transaction created for Product ID "
                + transaction.getProductId()
        );
    }

    public void displayAllTransactions() {

        System.out.println(
                "\n===== ALL TRANSACTIONS ====="
        );

        for (Transaction transaction :
                transactions) {

            System.out.println(
                    "Transaction ID: "
                    + transaction.getTransactionId()
            );

            System.out.println(
                    "Product ID: "
                    + transaction.getProductId()
            );

            System.out.println(
                    "Buyer ID: "
                    + transaction.getBuyerId()
            );

            System.out.println(
                    "Seller ID: "
                    + transaction.getSellerId()
            );

            System.out.println(
                    "Status: "
                    + transaction.getStatus()
            );

            System.out.println(
                    "------------------------"
            );
        }
    }

    public void completeTransaction(
            Transaction transaction) {

        System.out.println(
                "Transaction completed successfully."
        );

        logger.logActivity(
                "Transaction completed for Product ID "
                + transaction.getProductId()
        );
    }

    public ArrayList<Transaction>
            getTransactions() {

        return transactions;
    }
}