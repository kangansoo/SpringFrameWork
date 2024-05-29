package springFW.ex03.di01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloMain {

	public static void main(String[] args) {
		//생성자 의존성 주입
		//HelloController controller = new HelloController(new HelloService());
		
		//setter 의존성 주입
//		HelloController controller = new HelloController();
//		controller.setHelloService(new HelloService());
//		controller.hello("홍길동");
		
		//Spring DL, DI, xml
		//look up 정보 = context 가져오기
		AbstractApplicationContext context = new GenericXmlApplicationContext("classpath:config/di01/application-config.xml");
		
		//팩토리 패턴
		IHelloService helloService = context.getBean("helloService", HelloService.class);
		//getBean은 object 클래스로 리턴하기 때문에 뒤에 다운캐스팅할 클래스 설정을 해야 함
		System.out.println(helloService.sayHello("홍길동"));
		
		//생성자
		HelloController helloController = context.getBean("helloController", HelloController.class);
		helloController.hello("홍길동");
		
		//setter
		HelloController helloController2 = context.getBean("helloController2", HelloController.class);
		helloController2.hello("홍길동");
		
		HelloController helloController3 = context.getBean("helloController3", HelloController.class);
		helloController3.hello("홍길동");
	}
}
