package com.infosys.Cart_Service.Controller;

import com.infosys.Cart_Service.Entity.Cart;
import com.infosys.Cart_Service.Repository.CartRepository;
import com.infosys.Cart_Service.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController
{
    @Autowired
    private CartService cartService;

    @PostMapping("/additem")
    public String addToCart(@RequestParam String userName, @RequestParam String productName,@RequestParam String sellerName,
                            @RequestParam int quantity)
    {
        productName = productName.trim();
        return cartService.addToCart(userName, productName, sellerName, quantity);
    }

    @GetMapping("/getcart")
    public List<Cart>getcart(@RequestParam  String userName)
    {
        return cartService.getCart(userName);
    }

    @DeleteMapping("/deleteitem")
    public String deleteItem(@RequestParam String userName,@RequestParam String productName,@RequestParam String sellerName)
    {
        return cartService.deleteItem(userName, productName, sellerName);
    }

    @PutMapping("/updatequantity")
    public String updateQuantity(@RequestParam String userName, @RequestParam String productName, @RequestParam String sellerName,
                                 @RequestParam int newQuantity)
    {
        return cartService.updateQuantity(userName, productName, sellerName, newQuantity);
    }

    @GetMapping("/gettotalprice")
    public String getCartTotal(@RequestParam String userName)
    {
        return cartService.getCartTotal(userName);
    }


}
