package com.infosys.Wishlist_Service.Controller;

import com.infosys.Wishlist_Service.Entity.Wishlist;
import com.infosys.Wishlist_Service.Entity.WishlistDto;
import com.infosys.Wishlist_Service.Service.WishlistService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wishlist")
public class WishlistController
{
    @Autowired
    private WishlistService wishlistService;

    @PostMapping("/addtowishlist")
    public String addToWishlist(@RequestBody WishlistDto wishlistDto)
    {
        return wishlistService.addToWishlist(wishlistDto.getUserName(), wishlistDto.getDisplayName(),wishlistDto.getShortDesc(),wishlistDto.getCategory());
    }

    @GetMapping("/getwishlist")
    public List<Wishlist>getWishlist(@RequestParam String userName)
    {
        return wishlistService.getWishlist(userName);
    }

    @DeleteMapping("/deletefromwishlist")
    public String deleteFromWishlist(@RequestParam String userName,String wishlistId )
    {
        return wishlistService.deleteFromWishlist(userName,wishlistId);
    }
}
