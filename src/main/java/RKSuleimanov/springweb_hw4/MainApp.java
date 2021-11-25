package RKSuleimanov.springweb_hw4;

import RKSuleimanov.springweb_hw4.data.Product;
import RKSuleimanov.springweb_hw4.repositories.ProductDao;
import RKSuleimanov.springweb_hw4.utils.SessionFactoryUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainApp {

	public static void main(String[] args) {
		SpringApplication.run(MainApp.class, args);

	SessionFactoryUtils sessionFactoryUtils = new SessionFactoryUtils();
       sessionFactoryUtils.init();

//        try {
//		ProductDao productDao = new ProductDao(sessionFactoryUtils);
////
////		System.out.println(productDao.findAll().toString());
////		productDao.deleteById(2L);
////		System.out.println(productDao.findAll().toString());
////		productDao.saveOrUpdate(new Product("Milk", 59));
////		System.out.println(productDao.findAll().toString());
////		productDao.saveOrUpdate(new Product("Soda", 44));
////		System.out.println(productDao.findAll().toString());
//
//	} catch (Exception e) {
//		e.printStackTrace();
//	} finally {
//		sessionFactoryUtils.shutdown();
//	}
	}
}
