package RKSuleimanov.springweb_hw4.services;

import RKSuleimanov.springweb_hw4.data.Product;
import RKSuleimanov.springweb_hw4.repositories.ProductDao;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ProductService {
    private ProductDao productDao;

    public ProductService(ProductDao productDao) {
        this.productDao = productDao;
    }

    public List<Product> getProductList(){
        return Collections.unmodifiableList(productDao.findAll());
    }

    public void changePrice(Long productId, int delta) {
        productDao.changePrice(productId, delta);
    }
}
