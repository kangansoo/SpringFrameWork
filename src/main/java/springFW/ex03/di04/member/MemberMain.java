package springFW.ex03.di04.member;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import springFW.ex03.di03.HelloController;

public class MemberMain {

	public static void main(String[] args) {
		AbstractApplicationContext context;
		context = new GenericXmlApplicationContext("classpath:config/di04/application-config.xml");

		
		MemberController controller = context.getBean("memberController", MemberController.class);
		controller.printInfo();
		
		context.close();
	}

}
