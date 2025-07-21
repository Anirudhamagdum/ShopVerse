package com.infosys.Wishlist_Service.Feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "ACCOUNT-SERVICE")
public interface UserClient
{
    @GetMapping("/api/account/checkuser")
    boolean isRegisteredUser(@RequestParam String userName);
}
