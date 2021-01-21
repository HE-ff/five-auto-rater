package ru.gk.fiveautorater.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DetailCheck {

    @JsonProperty("location")
    private Location location;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("bonuses")
    private Bonuses bonuses;
    @JsonProperty("products")
    private List<Product> products = null;
    @JsonProperty("card_type")
    private String cardType;
    @JsonProperty("card_number")
    private String cardNumber;
    @JsonProperty("promotions")
    private List<Promotion> promotions = null;
    @JsonProperty("partner")
    private Object partner;
    @JsonProperty("stickers")
    private Stickers stickers;
    @JsonProperty("trn_type")
    private String trnType;
    @JsonProperty("sum")
    private Double sum;
    @JsonProperty("rate_status")
    private RateStatus rateStatus;
    @JsonProperty("is_nps_available")
    private Boolean isNpsAvailable;


    public DetailCheck() {
    }

    @JsonProperty("location")
    public Location getLocation() {
        return location;
    }

    @JsonProperty("location")
    public void setLocation(Location location) {
        this.location = location;
    }

    @JsonProperty("created_at")
    public String getCreatedAt() {
        return createdAt;
    }

    @JsonProperty("created_at")
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @JsonProperty("bonuses")
    public Bonuses getBonuses() {
        return bonuses;
    }

    @JsonProperty("bonuses")
    public void setBonuses(Bonuses bonuses) {
        this.bonuses = bonuses;
    }

    @JsonProperty("products")
    public List<Product> getProducts() {
        return products;
    }

    @JsonProperty("products")
    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @JsonProperty("card_type")
    public String getCardType() {
        return cardType;
    }

    @JsonProperty("card_type")
    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    @JsonProperty("card_number")
    public String getCardNumber() {
        return cardNumber;
    }

    @JsonProperty("card_number")
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @JsonProperty("promotions")
    public List<Promotion> getPromotions() {
        return promotions;
    }

    @JsonProperty("promotions")
    public void setPromotions(List<Promotion> promotions) {
        this.promotions = promotions;
    }

    @JsonProperty("partner")
    public Object getPartner() {
        return partner;
    }

    @JsonProperty("partner")
    public void setPartner(Object partner) {
        this.partner = partner;
    }

    @JsonProperty("stickers")
    public Stickers getStickers() {
        return stickers;
    }

    @JsonProperty("stickers")
    public void setStickers(Stickers stickers) {
        this.stickers = stickers;
    }

    @JsonProperty("trn_type")
    public String getTrnType() {
        return trnType;
    }

    @JsonProperty("trn_type")
    public void setTrnType(String trnType) {
        this.trnType = trnType;
    }

    @JsonProperty("sum")
    public Double getSum() {
        return sum;
    }

    @JsonProperty("sum")
    public void setSum(Double sum) {
        this.sum = sum;
    }

    @JsonProperty("rate_status")
    public RateStatus getRateStatus() {
        return rateStatus;
    }

    @JsonProperty("rate_status")
    public void setRateStatus(RateStatus rateStatus) {
        this.rateStatus = rateStatus;
    }

    @JsonProperty("is_nps_available")
    public Boolean getIsNpsAvailable() {
        return isNpsAvailable;
    }

    @JsonProperty("is_nps_available")
    public void setIsNpsAvailable(Boolean isNpsAvailable) {
        this.isNpsAvailable = isNpsAvailable;
    }


    public class Bonuses {

        @JsonProperty("transfer")
        private Integer transfer;
        @JsonProperty("refill")
        private Integer refill;
        @JsonProperty("withdrawal")
        private Integer withdrawal;

        @JsonProperty("transfer")
        public Integer getTransfer() {
            return transfer;
        }

        @JsonProperty("transfer")
        public void setTransfer(Integer transfer) {
            this.transfer = transfer;
        }

        @JsonProperty("refill")
        public Integer getRefill() {
            return refill;
        }

        @JsonProperty("refill")
        public void setRefill(Integer refill) {
            this.refill = refill;
        }

        @JsonProperty("withdrawal")
        public Integer getWithdrawal() {
            return withdrawal;
        }

        @JsonProperty("withdrawal")
        public void setWithdrawal(Integer withdrawal) {
            this.withdrawal = withdrawal;
        }

    }


    public  static  class Location {

        @JsonProperty("address")
        private String address;

        @JsonProperty("address")
        public String getAddress() {
            return address;
        }

        @JsonProperty("address")
        public void setAddress(String address) {
            this.address = address;
        }

    }

    public static class Product {

        @JsonProperty("comment")
        private Object comment;
        @JsonProperty("amount")
        private Double amount;
        @JsonProperty("code")
        private String code;
        @JsonProperty("title")
        private String title;
        @JsonProperty("price_sum")
        private Double priceSum;
        @JsonProperty("rate")
        private Object rate;

        public Product() {
        }

        @JsonProperty("comment")
        public Object getComment() {
            return comment;
        }

        @JsonProperty("comment")
        public void setComment(Object comment) {
            this.comment = comment;
        }

        @JsonProperty("amount")
        public Double getAmount() {
            return amount;
        }

        @JsonProperty("amount")
        public void setAmount(Double amount) {
            this.amount = amount;
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

        @JsonProperty("price_sum")
        public Double getPriceSum() {
            return priceSum;
        }

        @JsonProperty("price_sum")
        public void setPriceSum(Double priceSum) {
            this.priceSum = priceSum;
        }

        @JsonProperty("rate")
        public Object getRate() {
            return rate;
        }

        @JsonProperty("rate")
        public void setRate(Object rate) {
            this.rate = rate;
        }
    }

    public static class Promotion {

        @JsonProperty("promo_name")
        private String promoName;
        @JsonProperty("points")
        private Integer points;
        @JsonProperty("type")
        private String type;
        @JsonProperty("description")
        private String description;
        @JsonProperty("promo_id")
        private Integer promoId;

        public Promotion() {
        }

        @JsonProperty("promo_name")
        public String getPromoName() {
            return promoName;
        }

        @JsonProperty("promo_name")
        public void setPromoName(String promoName) {
            this.promoName = promoName;
        }

        @JsonProperty("points")
        public Integer getPoints() {
            return points;
        }

        @JsonProperty("points")
        public void setPoints(Integer points) {
            this.points = points;
        }

        @JsonProperty("type")
        public String getType() {
            return type;
        }

        @JsonProperty("type")
        public void setType(String type) {
            this.type = type;
        }

        @JsonProperty("description")
        public String getDescription() {
            return description;
        }

        @JsonProperty("description")
        public void setDescription(String description) {
            this.description = description;
        }

        @JsonProperty("promo_id")
        public Integer getPromoId() {
            return promoId;
        }

        @JsonProperty("promo_id")
        public void setPromoId(Integer promoId) {
            this.promoId = promoId;
        }

    }


    public static class RateStatus {

        @JsonProperty("reason")
        private String reason;
        @JsonProperty("code")
        private Integer code;

        public RateStatus() {
        }

        @JsonProperty("reason")
        public String getReason() {
            return reason;
        }

        @JsonProperty("reason")
        public void setReason(String reason) {
            this.reason = reason;
        }

        @JsonProperty("code")
        public Integer getCode() {
            return code;
        }

        @JsonProperty("code")
        public void setCode(Integer code) {
            this.code = code;
        }

    }

    public static class Stickers {

        @JsonProperty("refill")
        private Integer refill;
        @JsonProperty("withdrawal")
        private Integer withdrawal;

        public Stickers() {
        }

        @JsonProperty("refill")
        public Integer getRefill() {
            return refill;
        }

        @JsonProperty("refill")
        public void setRefill(Integer refill) {
            this.refill = refill;
        }

        @JsonProperty("withdrawal")
        public Integer getWithdrawal() {
            return withdrawal;
        }

        @JsonProperty("withdrawal")
        public void setWithdrawal(Integer withdrawal) {
            this.withdrawal = withdrawal;
        }
    }

}
