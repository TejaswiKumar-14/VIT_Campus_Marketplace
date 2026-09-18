package model;

public class Transaction {

    private int transactionId;
    private int productId;
    private int buyerId;
    private int sellerId;
    private String status;

    public Transaction(int transactionId, int productId,
                       int buyerId, int sellerId,
                       String status) {

        this.transactionId = transactionId;
        this.productId = productId;
        this.buyerId = buyerId;
        this.sellerId = sellerId;
        this.status = status;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public int getProductId() {
        return productId;
    }

    public int getBuyerId() {
        return buyerId;
    }

    public int getSellerId() {
        return sellerId;
    }

    public String getStatus() {
        return status;
    }
}