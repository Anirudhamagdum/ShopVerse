package com.infosys.Product_Service.Repository;
import com.infosys.Product_Service.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,String>
{
//    Optional<Product> findByProductName(String productName);
    List<Product> findByProductNameStartingWithIgnoreCase(String prefix);
    Product findByProductNameAndSellerName(String productName, String sellerName);
}
