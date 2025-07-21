package com.infosys.Order_Service.Entity;


import lombok.Data;

@Data
public class FeedbackDto
{
    private String userName;
    private String orderId;
    private String feedback;
    private int rating;
}
