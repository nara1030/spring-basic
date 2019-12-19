package expert002;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Driver {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("expert002/expert002.xml");

		Car aCar = context.getBean("aCar", Car.class);
		Tire aTire = context.getBean("aTire", Tire.class);
		aCar.setTire(aTire);

		System.out.println(aCar.getTireBrand());
	}
}
