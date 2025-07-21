package com.infosys.Wishlist_Service.Service;
import com.infosys.Wishlist_Service.Entity.Wishlist;
import com.infosys.Wishlist_Service.Feign.UserClient;
import com.infosys.Wishlist_Service.Repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class WishlistService
{
    @Autowired
    private WishlistRepository wishrepo;

    @Autowired
    private UserClient user;

    public String addToWishlist(String userName,String displayName, String shortDesc, String category)
    {
        String wishlistId = UUID.randomUUID().toString().substring(0,5).toUpperCase();

        boolean isRegistered = user.isRegisteredUser(userName);

        if(!isRegistered)
        {
            return "Access Denied,User Not Registered!";
        }
        Wishlist wishlist = new Wishlist(wishlistId,userName, displayName,shortDesc,category);
        wishrepo.save(wishlist);
        return "Item Added Successfully ";
    }

    public List<Wishlist>getWishlist(String userName)
    {

        List<Wishlist> wishlistItems = wishrepo.findByUserName(userName);
        if (wishlistItems.isEmpty())
        {
            throw new RuntimeException("No Item Found In Wishlist!");
        }

        boolean isRegistered = user.isRegisteredUser(userName);
        if(!isRegistered)
        {
            throw  new RuntimeException("Access Denied, User Not Registered!");
        }
        return wishrepo.findByUserName(userName);
    }

    public String deleteFromWishlist(String userName,String wishlistId)
    {
        List<Wishlist> wishlistItems = wishrepo.findByUserName(userName);
        Wishlist wishlist = wishrepo.findById(wishlistId).orElse(null);

        if(wishlist==null)
        {
            return "No Item Found!";
        }
        boolean isRegistered = user.isRegisteredUser(userName);
        if(!isRegistered)
        {
            return "Access Denied,User Not Registered ";
        }
        wishrepo.delete(wishlist);
        return "Item Removed From Wishlist Successfully";
    }
}
