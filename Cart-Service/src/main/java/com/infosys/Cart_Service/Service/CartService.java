package com.infosys.Cart_Service.Service;
import com.infosys.Cart_Service.Entity.Cart;
import com.infosys.Cart_Service.Entity.ProductResponse;
import com.infosys.Cart_Service.Feign.ProductClient;
import com.infosys.Cart_Service.Repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CartService
{
    @Autowired
    private CartRepository cartrepo;

    @Autowired
    private ProductClient productClient;

    public String addToCart(String userName, String productName, String sellerName, int quantity)
    {
        Cart existingCart = cartrepo.findByUserNameAndProductNameAndSellerName(userName,productName,sellerName);
        ProductResponse product = productClient.getProductDetails(productName,sellerName);

        if(existingCart!= null)
        {
            existingCart.setQuantity(existingCart.getQuantity()+quantity);
            existingCart.setCartOfferPrice(product.getPrice()-product.getDiscount());
            existingCart.setPrice(product.getPrice());
            existingCart.setDiscount(product.getDiscount());
            existingCart.setDileveryCharges(product.getDeliveryCharges());
            cartrepo.save(existingCart);
            return "Cart Updated For "+productName;
        }

        String cartId = UUID.randomUUID().toString().substring(0, 5).toUpperCase();

        Cart cart = new Cart();
        cart.setCartId(cartId);
        cart.setUserName(userName);
        cart.setProductName(productName);
        cart.setSellerName(sellerName);
        cart.setQuantity(quantity);
        cart.setPrice(product.getPrice());
        cart.setDiscount(product.getDiscount());
        cart.setDileveryCharges(product.getDeliveryCharges());
        cart.setCartOfferPrice(product.getPrice()-product.getDiscount());
        cartrepo.save(cart);
        return "Item Added To Cart";

    }

    public List<Cart>getCart(String userName)
    {
        return cartrepo.findByUserName(userName);
    }

    public String deleteItem(String userName,String productName, String sellerName)
    {
        Cart existingCart = cartrepo.findByUserNameAndProductNameAndSellerName(userName, productName, sellerName);
        if(existingCart==null)
        {
            return "Item Not Found In Cart!";
        }
        int currentQuantity = existingCart.getQuantity();
        if(currentQuantity>1)
        {
            existingCart.setQuantity(currentQuantity-1);
            cartrepo.save(existingCart);
            return "Item removed From Cart Successfully";
        }
        cartrepo.delete(existingCart);
        return "Item removed From Cart Successfully";
    }

    public String updateQuantity(String userName,String productName,String sellerName,int newQuantity)
    {
        Cart cart = cartrepo.findByUserNameAndProductNameAndSellerName(userName,productName,sellerName);
        cart.setQuantity(newQuantity);

        if(cart==null)
        {
            return "Item Not Found In Cart!";
        }
        cartrepo.save(cart);
        return "Item Quantity Updated Successfully";
    }

    public String getCartTotal(String userName)
    {
        List<Cart>cartItems = cartrepo.findByUserName(userName);
        double totalAmount = 0;
        double toalDeliveryCharges = 0;

        for(Cart item : cartItems)
        {
            toalDeliveryCharges+=(item.getDileveryCharges()* item.getQuantity());
            totalAmount+=(item.getCartOfferPrice()* item.getQuantity())+ item.getDileveryCharges();
        }
        return "Total Delivery Charges for All Items Is: "+toalDeliveryCharges+"\n"+
                "Total Item Cost In The Cart: "+(totalAmount-toalDeliveryCharges)+"\n"+
                "Total Value Of The Cart Is: "+totalAmount;
    }


}
