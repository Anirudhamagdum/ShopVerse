package com.infosys.Order_Service.Feign;

import com.infosys.Order_Service.Entity.CartDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "CART-SERVICE")
public interface CartClient
{
    @GetMapping("/api/cart/getcart")
    List<CartDTO>getCart(@RequestParam String userName);

    @DeleteMapping("/api/cart/deleteitem")
    String deleteItem(@RequestParam String userName,@RequestParam String productName,@RequestParam String sellerName);
}
