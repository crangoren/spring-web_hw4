package RKSuleimanov.springweb_hw4.repositories;

import RKSuleimanov.springweb_hw4.data.Product;
import RKSuleimanov.springweb_hw4.utils.SessionFactoryUtils;
import org.hibernate.Session;

public class ProductRepositoryImpl {

    public void changePrice(Long productId, int delta) {
        int oldPrice;
        int newPrice;
        try (Session session = SessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, productId);
            oldPrice = product.getPrice();
            newPrice = oldPrice + delta;
            session.createQuery("update Product set price = :price where id = :id")
                    .setParameter("id", productId)
                    .setParameter("price", newPrice)
                    .executeUpdate();
        }

    }
}
