package RKSuleimanov.springweb_hw4.repositories;

import RKSuleimanov.springweb_hw4.data.Product;

import java.util.List;

public interface IProductDao {
    Product findById(Long id);
    List<Product> findAll();
    void deleteById(Long id);
    Product saveOrUpdate(Product product);
    void changePrice(Long productId, int delta);
}
