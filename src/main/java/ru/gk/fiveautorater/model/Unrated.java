package ru.gk.fiveautorater.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Unrated {

    @JsonProperty("id")
    private String id;
    @JsonProperty("card")
    private String card;
    @JsonProperty("card_type")
    private String cardType;
    @JsonProperty("trn_type")
    private String trnType;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("location")
    private String location;
    @JsonProperty("sum")
    private Double sum;
    @JsonProperty("transaction_products")
    private List<TransactionProduct> transactionProducts = null;
    @JsonProperty("card_number")
    private String cardNumber;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("card")
    public String getCard() {
        return card;
    }

    @JsonProperty("card")
    public void setCard(String card) {
        this.card = card;
    }

    @JsonProperty("card_type")
    public String getCardType() {
        return cardType;
    }

    @JsonProperty("card_type")
    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    @JsonProperty("trn_type")
    public String getTrnType() {
        return trnType;
    }

    @JsonProperty("trn_type")
    public void setTrnType(String trnType) {
        this.trnType = trnType;
    }

    @JsonProperty("created_at")
    public String getCreatedAt() {
        return createdAt;
    }

    @JsonProperty("created_at")
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @JsonProperty("location")
    public String getLocation() {
        return location;
    }

    @JsonProperty("location")
    public void setLocation(String location) {
        this.location = location;
    }

    @JsonProperty("sum")
    public Double getSum() {
        return sum;
    }

    @JsonProperty("sum")
    public void setSum(Double sum) {
        this.sum = sum;
    }

    @JsonProperty("transaction_products")
    public List<TransactionProduct> getTransactionProducts() {
        return transactionProducts;
    }

    @JsonProperty("transaction_products")
    public void setTransactionProducts(List<TransactionProduct> transactionProducts) {
        this.transactionProducts = transactionProducts;
    }

    @JsonProperty("card_number")
    public String getCardNumber() {
        return cardNumber;
    }

    @JsonProperty("card_number")
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public class TransactionProduct {

        @JsonProperty("average_rating")
        private Double averageRating;
        @JsonProperty("code")
        private String code;
        @JsonProperty("title")
        private String title;
        @JsonProperty("img_link")
        private Object imgLink;
        @JsonProperty("price")
        private Double price;
        @JsonProperty("rates_count_in_period")
        private Integer ratesCountInPeriod;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        @JsonProperty("average_rating")
        public Double getAverageRating() {
            return averageRating;
        }

        @JsonProperty("average_rating")
        public void setAverageRating(Double averageRating) {
            this.averageRating = averageRating;
        }

        @JsonProperty("code")
        public String getCode() {
            return code;
        }

        @JsonProperty("code")
        public void setCode(String code) {
            this.code = code;
        }

        @JsonProperty("title")
        public String getTitle() {
            return title;
        }

        @JsonProperty("title")
        public void setTitle(String title) {
            this.title = title;
        }

        @JsonProperty("img_link")
        public Object getImgLink() {
            return imgLink;
        }

        @JsonProperty("img_link")
        public void setImgLink(Object imgLink) {
            this.imgLink = imgLink;
        }

        @JsonProperty("price")
        public Double getPrice() {
            return price;
        }

        @JsonProperty("price")
        public void setPrice(Double price) {
            this.price = price;
        }

        @JsonProperty("rates_count_in_period")
        public Integer getRatesCountInPeriod() {
            return ratesCountInPeriod;
        }

        @JsonProperty("rates_count_in_period")
        public void setRatesCountInPeriod(Integer ratesCountInPeriod) {
            this.ratesCountInPeriod = ratesCountInPeriod;
        }

        @JsonAnyGetter
        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        @JsonAnySetter
        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }

}
