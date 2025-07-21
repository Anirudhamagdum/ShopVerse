package com.infosys.Order_Service.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductResponse
{
    private String productName;
    private String sellerName;
    private Double price;
    private Double discount;
    private Double deliveryCharges;
    private int avgRating;
    private String category;
}

