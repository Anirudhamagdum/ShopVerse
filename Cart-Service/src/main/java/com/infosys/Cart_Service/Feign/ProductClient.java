package com.infosys.Cart_Service.Feign;

import com.infosys.Cart_Service.Entity.ProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "PRODUCT-SERVICE")
public interface ProductClient
{
    @GetMapping("api/product/getdetails")
    ProductResponse getProductDetails(@RequestParam String productName, @RequestParam String sellerName);

}
