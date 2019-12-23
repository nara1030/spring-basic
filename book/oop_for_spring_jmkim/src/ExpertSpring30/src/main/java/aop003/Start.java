package aop003;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Start {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("aop003.xml", Start.class);

		Person romeo = context.getBean("aBoy", Person.class);
		Person juliet = context.getBean("aGirl", Person.class);

		romeo.runSomething();
		juliet.runSomething();
	}
}
