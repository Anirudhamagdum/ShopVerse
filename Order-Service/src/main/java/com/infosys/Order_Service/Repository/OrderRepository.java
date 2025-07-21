package com.infosys.Order_Service.Repository;

import com.infosys.Order_Service.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order,String>
{
    List<Order>findByuserName(String userName);
    Optional<Order>findByOrderId(String orderId);
    List<Order>findByuserNameAndOrderStatus(String userName, String orderStatus);
}
