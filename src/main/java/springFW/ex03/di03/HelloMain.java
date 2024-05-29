package springFW.ex03.di03;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloMain {

	public static void main(String[] args) {
		//Spring DL, DI, xml
		//look up 정보 = context 가져오기
		AbstractApplicationContext context;
//		context = new GenericXmlApplicationContext("classpath:config/di03/application-config.xml");
		context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		HelloController controller = context.getBean("helloController", HelloController.class);
		controller.hello("홍길동");
		
		context.close();
	}
}
