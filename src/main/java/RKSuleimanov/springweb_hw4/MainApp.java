package RKSuleimanov.springweb_hw4;

import RKSuleimanov.springweb_hw4.utils.SessionFactoryUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainApp {

	public static void main(String[] args) {
		SpringApplication.run(MainApp.class, args);

	SessionFactoryUtils sessionFactoryUtils = new SessionFactoryUtils();
       sessionFactoryUtils.init();

	}
}
