package com.infosys.Product_Service.Entity;
import lombok.Data;

@Data
public class ProductResponse
{
    private String productName;
    private String sellerName;
    private Double price;
    private Double discount;
    private Double deliveryCharges;
    private String category;
}
