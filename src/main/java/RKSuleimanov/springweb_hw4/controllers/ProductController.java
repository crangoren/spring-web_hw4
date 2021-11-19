package RKSuleimanov.springweb_hw4.controllers;

import RKSuleimanov.springweb_hw4.data.Product;
import RKSuleimanov.springweb_hw4.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> showProducts(){
        return productService.getProductList();
    }

    @GetMapping("/products/change_cost")
    public void changeCost(@RequestParam Long productId, @RequestParam Integer delta){
        productService.changeCost(productId, delta);
    }

}
