package RKSuleimanov.springweb_hw4.repositories;

import RKSuleimanov.springweb_hw4.data.Product;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class ProductRepository {
    public List<Product> products;


    @PostConstruct
    public void init(){
    products = new ArrayList<>(List.of(
       new Product(1L, "Bread", 55),
       new Product(2L, "Apples", 129),
       new Product(3L, "Milk", 52),
       new Product(4L, "Soda", 35),
       new Product(5L, "Sugar", 50),
       new Product(6L, "Salt", 19),
       new Product(7L, "Tea", 109)
    ));
    }

    public List<Product> getProductList(){
        return  Collections.unmodifiableList(products);
    }

    public Product getProductById(Long id){
        return products.stream()
                .filter(p -> p.getId()
                .equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

}
