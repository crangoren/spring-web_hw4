package RKSuleimanov.springweb_hw4.services;

import RKSuleimanov.springweb_hw4.data.Product;
import RKSuleimanov.springweb_hw4.repositories.ProductRepository;
import org.apache.catalina.valves.StuckThreadDetectionValve;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll(){
        return Collections.unmodifiableList(productRepository.findAll());
    }

    public Optional<Product> findById(Long id){
        return productRepository.findById(id);
    }

    public void changePrice(Long productId, Integer delta) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new RKSuleimanov.springweb_hw4.exceptions.ResourceNotFoundException("Unable to change product's price, product not found " + productId));
        product.setPrice(product.getPrice() + delta);
        productRepository.save(product);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public List<Product> findByPriceBetween(Integer min, Integer max) {
        return productRepository.findAllByPriceBetween(min, max);
    }
}
