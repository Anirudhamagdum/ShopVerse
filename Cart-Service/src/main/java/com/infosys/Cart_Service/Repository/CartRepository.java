package com.infosys.Cart_Service.Repository;

import com.infosys.Cart_Service.Entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart,String>
{
    List<Cart>findByUserName(String userName);

    Cart findByUserNameAndProductNameAndSellerName(String username, String productName, String sellerName);

    void deleteByUserNameAndProductNameAndSellerName(String userName, String productName, String sellerName);
}
