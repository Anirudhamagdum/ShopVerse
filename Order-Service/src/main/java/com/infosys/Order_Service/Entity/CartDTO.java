package com.infosys.Order_Service.Entity;
import lombok.Data;

@Data
public class CartDTO {
    private String cartId;
    private String userName;
    private String productName;
    private String sellerName;
    private int quantity;
    private Double price;
    private Double discount;
    private Double deliveryCharges;
    private Double cartOfferPrice;
}
