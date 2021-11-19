package RKSuleimanov.springweb_hw4.services;

import RKSuleimanov.springweb_hw4.data.Product;
import RKSuleimanov.springweb_hw4.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProductList(){
        return Collections.unmodifiableList(productRepository.getProductList());
    }

    public void changeCost(Long productId, Integer delta) {
        productRepository.getProductById(productId).setCost(productRepository.getProductById(productId).getCost() + delta);

    }
}
