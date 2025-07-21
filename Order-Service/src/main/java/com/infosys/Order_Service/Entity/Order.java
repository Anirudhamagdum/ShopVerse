package com.infosys.Order_Service.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "orders")
public class Order
{
    @Id
    private String orderId;

    private String userName;

    private String displayName;

    private String category;

    private String sellerName;

    private Double price;

    private int quantity;

    private Double totalPrice;

    private LocalDate orderedDate;

    private String orderStatus;

    private String feedback;

    private int rating;

}
