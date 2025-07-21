package com.infosys.Order_Service.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderDTO
{
    private String userName;
    private String orderId;
    private String orderStatus;
    private String category;
    private LocalDate date;
}
