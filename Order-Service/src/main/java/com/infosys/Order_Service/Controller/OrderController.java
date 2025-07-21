package com.infosys.Order_Service.Controller;

import com.infosys.Order_Service.Entity.FeedbackDto;
import com.infosys.Order_Service.Entity.Order;
import com.infosys.Order_Service.Service.OrderService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController
{
    @Autowired
    private OrderService orderService;

    @PostMapping("/placeorder")
    public String placeOrder(@RequestBody Order order)
    {
        return orderService.placeOrder(order);
    }

    @GetMapping("/getallorders")
    public List<Order>getAllOrders(@RequestParam String userName)
    {
        return orderService.getAllOrders(userName);
    }

    @GetMapping("/getorderbystatus")
    public List<Order>getOrderByStatus(@RequestParam String userName, @RequestParam String orderStatus)
    {
        return orderService.getOrderByStatus(userName, orderStatus);
    }

    @PutMapping("/cancelorder")
    public String cancelOrder(@RequestParam String orderId, @RequestParam String userName)
    {
        return orderService.cancelOrder(orderId,userName);
    }

    @PutMapping("/returnorder")
    public String returnOrder(@RequestParam String orderId, @RequestParam String userName)
    {
        return orderService.returnOrder(orderId,userName);
    }

    @PostMapping("/addfeedback")
    public String addFeedback(@RequestBody FeedbackDto feedbackDto)
    {
        return orderService.addFeedback(feedbackDto.getUserName(), feedbackDto.getOrderId(), feedbackDto.getFeedback(), feedbackDto.getRating());
    }

    @PostMapping("/placeorderfromcart")
    public String placeOrderFromCart(@RequestParam String userName,@RequestParam String productName,@RequestParam String sellerName)
    {
        return orderService.placeOrderFromCart(userName, productName, sellerName);
    }

    @PostMapping("/markasdelivered")
    public String markAsDelivered(@RequestParam String orderId, @RequestParam String userName)
    {
        return orderService.markAsDelivered(orderId,userName);
    }

}
