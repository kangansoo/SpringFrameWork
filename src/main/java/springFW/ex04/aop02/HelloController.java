package springFW.ex04.aop02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class HelloController {
	@Autowired
	IHelloService helloService;
	
	public void hello(String name) {
		System.out.println("HelloController: " + helloService.sayHello("홍길동"));
	}
	
	public void goodbye(String name) {
		System.out.println("HelloController: " + helloService.sayGoodbye("고길동"));
	}
}
