package com.infosys.Product_Service.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product
{
    @Id
    private String productId;

    @NotBlank(message = "Product Name can not be empty!")
    private String productName;

    private String description;

    private Double price;

    private Double discount;

    private Double deliveryCharges;

    private int averageRating;

    private String sellerName;

    private String category;

}
