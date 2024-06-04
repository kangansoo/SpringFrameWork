package springFw.ex03.di02;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CustomerMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext context = new GenericXmlApplicationContext("classpath:config/di02/application-config.xml");

		Customer customer = context.getBean(Customer.class);
		System.out.println(customer);
		
		Customer customer1 = context.getBean(Customer.class);
		System.out.println(customer == customer1);
		
		Person person1 = context.getBean(Person.class);
		Person person2 = context.getBean(Person.class);
		System.out.println(person1 == person2);
		System.out.println(person1.hashCode()+","+person2.hashCode());
				
		context.close();
	}
	
}
