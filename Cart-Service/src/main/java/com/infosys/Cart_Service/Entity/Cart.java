package com.infosys.Cart_Service.Entity;

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
public class Cart
{
    @Id
    private String cartId;

    @NotBlank(message = "Product Name can't be blank!")
    private String productName;

    @NotBlank(message = "User Name can't Be Blank")
    private String userName;

    @NotBlank(message = "Seller Name Can't Be Blank!")
    private String sellerName;

    private int quantity;

    private Double cartOfferPrice;

    private Double price;

    private Double discount;

    private Double dileveryCharges;


}
