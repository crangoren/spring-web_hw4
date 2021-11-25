package RKSuleimanov.springweb_hw4.repositories;


import RKSuleimanov.springweb_hw4.data.Product;
import RKSuleimanov.springweb_hw4.utils.SessionFactoryUtils;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class ProductDao implements IProductDao {
    private SessionFactoryUtils sessionFactoryUtils;

    public ProductDao(SessionFactoryUtils sessionFactoryUtils) {
        this.sessionFactoryUtils = sessionFactoryUtils;
    }

    public ProductDao() {
    }

    @Override
    public Product findById(Long id) {
        try (Session session = SessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.getTransaction().commit();
            return product;
        }
    }

    @Override
    public List<Product> findAll() {
        try (Session session = SessionFactoryUtils.getSession()) {
            session.beginTransaction();
            List<Product> products = session.createQuery("select p from Product p").getResultList();
            session.getTransaction().commit();
            return Collections.unmodifiableList(products);
        }
    }

    @Override
    public void deleteById(Long id) {
        try (Session session = SessionFactoryUtils.getSession()) {
            session.beginTransaction();
            session.createQuery("delete Product where id = :id").setParameter("id", id).executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Override
    public void changePrice(Long productId, int delta) {
        int oldPrice;
        int newPrice;
        try (Session session = SessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, productId);
                    //session.createQuery("select p from Product p where id = :id").setParameter("id", productId).getSingleResult();
            oldPrice = product.getPrice();
            newPrice = oldPrice + delta;
            session.createQuery("update Product set price = :price where id = :id")
                    .setParameter("id", productId)
                    .setParameter("price", newPrice)
                    .executeUpdate();
        }

    }


    @Override
    public Product saveOrUpdate(Product product) {
        try (Session session = SessionFactoryUtils.getSession()) {
            session.beginTransaction();
            String newTitle = product.getTitle();
            int newPrice = product.getPrice();
            List<Product> products = session.createQuery("select p from Product p").getResultList();
            if (products.stream().anyMatch((p) -> p.getTitle().equalsIgnoreCase(newTitle))) {
                session.createQuery("update Product set price = :price where title = :title")
                        .setParameter("title", newTitle)
                        .setParameter("price", newPrice)
                        .executeUpdate();
            } else {
                session.save(new Product(newTitle, newPrice));
            }
            return product;
        }

    }
}

