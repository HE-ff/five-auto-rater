package ru.gk.fiveautorater.model;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Product {

    @JsonProperty("rating")
    private String rating;
    @JsonProperty("transaction_id")
    private String transactionId;
    @JsonProperty("product_id")
    private String productId;

    public Product() {
    }

    public Product(String rating, String transactionId, String productId) {
        this.rating = rating;
        this.transactionId = transactionId;
        this.productId = productId;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}


