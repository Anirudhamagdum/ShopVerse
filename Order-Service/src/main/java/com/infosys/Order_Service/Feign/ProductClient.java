package com.infosys.Order_Service.Feign;

import com.infosys.Order_Service.Entity.ProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "PRODUCT-SERVICE")
public interface ProductClient
{
    @RequestMapping("/api/product/getdetails")
    ProductResponse getProductDetails(@RequestParam String productName, @RequestParam String sellerName);
}
