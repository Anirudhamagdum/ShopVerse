package com.infosys.Product_Service.Controller;
import com.infosys.Product_Service.Entity.Product;
import com.infosys.Product_Service.Entity.ProductResponse;
import com.infosys.Product_Service.Repository.ProductRepository;
import com.infosys.Product_Service.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController
{
    @Autowired
    private ProductService service;

    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/notify")
    public String notify(@RequestParam String username)
    {
        return service.notifyFromAccount(username);
    }

    @GetMapping("/getallproducts")
    public List<Product>getAllProducts()
    {
        return service.getAllProducts();
    }

    @GetMapping("/searchproduct")
    public List<Product>searchByPrefix(@RequestParam String prefix)
    {
        return service.searchByPrefix(prefix);
    }

    @PostMapping("/addproduct")
    public Product addProduct(@RequestBody Product product)
    {
       return service.addProduct(product);
    }

    @GetMapping("/getdetails")
    public ProductResponse getProductDetails(@RequestParam String productName, @RequestParam String sellerName )
    {
        Product product = productRepository.findByProductNameAndSellerName(productName,sellerName);

        if(product == null)
        {
            throw new RuntimeException("Product Not Found!");
        }

        ProductResponse response = new ProductResponse();
        response.setProductName(product.getProductName());
        response.setSellerName(product.getSellerName());
        response.setDiscount(product.getDiscount());
        response.setPrice(product.getPrice());
        response.setDeliveryCharges(product.getDeliveryCharges());

        return response;
    }
}
