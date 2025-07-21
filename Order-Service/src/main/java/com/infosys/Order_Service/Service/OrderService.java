package com.infosys.Order_Service.Service;
import com.infosys.Order_Service.Entity.CartDTO;
import com.infosys.Order_Service.Entity.Order;
import com.infosys.Order_Service.Entity.ProductResponse;
import com.infosys.Order_Service.Feign.CartClient;
import com.infosys.Order_Service.Feign.ProductClient;
import com.infosys.Order_Service.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderService
{
    @Autowired
    private OrderRepository repo;

    @Autowired
    private CartClient cartClient;

    @Autowired
    private ProductClient productClient;

    public String placeOrder(Order order)
    {

        order.setOrderId(UUID.randomUUID().toString().substring(0,5).toUpperCase());
        order.setOrderedDate(LocalDate.now());
        order.setTotalPrice(order.getPrice()*order.getQuantity());
        order.setOrderStatus("PLACED");
        repo.save(order);
        return "Order Placed Successfully";
    }

    public String placeOrderFromCart(String userName,String productName, String sellerName)
    {
        List<CartDTO>cartItems = cartClient.getCart(userName);

        if(cartItems.isEmpty())
        {
            return "Cart Is Empty,Can't Place Order!";
        }

        for(CartDTO cart: cartItems)
        {
            ProductResponse product = productClient.getProductDetails(cart.getProductName(),cart.getSellerName());
            Order order = new Order();
            order.setOrderId(UUID.randomUUID().toString().substring(0,5).toUpperCase());
            order.setUserName(userName);
            order.setDisplayName(cart.getProductName());
            order.setCategory(product.getCategory());
            order.setSellerName(cart.getSellerName());
            order.setPrice(cart.getPrice());
            order.setQuantity(cart.getQuantity());
            double deliveryCharge = cart.getDeliveryCharges() != null ? cart.getDeliveryCharges() : 0.0;
            double totalPrice = (cart.getPrice() - cart.getDiscount()) * cart.getQuantity() + deliveryCharge;
            order.setTotalPrice(totalPrice);
            order.setOrderedDate(LocalDate.now());
            order.setOrderStatus("PLACED");
            repo.save(order);
            cartClient.deleteItem(userName,cart.getProductName(),cart.getSellerName());
        }
        return "Order Placed Successfully.";

    }

    public List<Order>getAllOrders(String userName)
    {
        return repo.findByuserName(userName);
    }

    public List<Order>getOrderByStatus(String userName, String orderStatus)
    {
        return repo.findByuserNameAndOrderStatus(userName,orderStatus);
    }

    public String cancelOrder(String orderId,String userName)
    {
        Order order = repo.findById(orderId).orElse(null);
        if(order==null)
        {
            return "Order Not Found";
        }
        else if(!(order.getUserName().equals(userName)))
        {
            return "Access Denied";
        }
        else if(!order.getOrderStatus().equalsIgnoreCase("PLACED"))
        {
            return "Only Placed Orders Can Be Canceled! ";
        }
        order.setOrderStatus("CANCELED");
        repo.save(order);
        return "Order Canceled Successfully. ";

    }

    public String returnOrder(String orderId, String userName)
    {
        Order order = repo.findById(orderId).orElse(null);

        if(order==null)
        {
            return "Order Not Found!";
        }
        else if(!(order.getUserName().equals(userName)))
        {
            return "Access Denied!";
        }
        else if (!order.getOrderStatus().equalsIgnoreCase("DELIVERED"))
        {
            return "Only Delivered Orders Can Be Returned! ";
        }

        LocalDate currentDate = LocalDate.now();
        if(order.getOrderedDate().plusDays(10).isBefore(currentDate))
        {
            return "Return Period Expired Can't Return Product After 10 Days!";
        }

        order.setOrderStatus("RETURNED");
        repo.save(order);
        return "Order Returned Successfully";

    }

    public String addFeedback(String userName, String orderId, String feedback, int rating)
    {
        Optional<Order>optionalOrder = repo.findByOrderId(orderId);

        if(optionalOrder.isEmpty())
        {
            return "Order Not Found!";
        }
        Order order = optionalOrder.get();

        if(!order.getUserName().equals(userName))
        {
            return "You Are Not Authorized Person To Give Feedback On This Order!";
        }
        if(!order.getOrderStatus().equalsIgnoreCase("DELIVERED"))
        {
            return "You can Only Give Feedback Once Product Is Delivered!";
        }
        order.setFeedback(feedback);
        order.setRating(rating);
        repo.save(order);
        return "Feedback Submitted Successfully";
    }

    public String markAsDelivered(String orderId, String userName)
    {
        Optional<Order>optionalOrder = repo.findByOrderId(orderId);
        if(optionalOrder.isEmpty())
        {
            return "Order Not Found!";
        }

        Order order = optionalOrder.get();
        if(!order.getUserName().equals(userName))
        {
            return "Access Denied!";
        }
        if(!order.getOrderStatus().equalsIgnoreCase("PLACED"))
        {
            return "Only Placed Orders Can be Marked As Delivered!";
        }
        order.setOrderStatus("DELIVERED");
        repo.save(order);
        return "Order Is Marked As Delivered";
    }

}
