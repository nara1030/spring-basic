package expert005;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Driver {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("expert005/expert005.xml");

		Car aCar = context.getBean("aCar", Car.class);
		
		System.out.println(aCar.getTireBrand());
	}
}
