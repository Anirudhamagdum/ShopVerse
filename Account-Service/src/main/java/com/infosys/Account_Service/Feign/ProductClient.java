package com.infosys.Account_Service.Feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "Product-Service")
public interface ProductClient
{
    @PostMapping("/api/product/notify")
    String notifyProductService(@RequestParam String username);
}

