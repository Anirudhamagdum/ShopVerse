package com.infosys.Wishlist_Service.Repository;

import com.infosys.Wishlist_Service.Entity.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface WishlistRepository extends JpaRepository<Wishlist,String>
{
    List<Wishlist>findByUserName(String userName);
    void deleteByUserNameAndDisplayName(String userName, String displayName);
}
