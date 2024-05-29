package springFW.ex03.di03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class HelloController {
	
//	@Autowired
//	IHelloService helloService;
	
	//밑의 소스코드를 변경하지 않아도 niceService를 DI할 수 있다.
	@Autowired
	@Qualifier("niceService")
	IHelloService helloService;
	
	//생성자 의존성 주입
	//멤버 변수에 객체를 받겠다는 의미 HelloService에 의존성을 제거
	public HelloController(IHelloService helloService) {
		this.helloService = helloService;
	}
	
	//Setter 의존성 주입
	public HelloController() {}
	public void setHelloService(IHelloService helloService) {
		this.helloService = helloService;
	}
	
	public void hello(String name) {
		System.out.println("HelloController: " + helloService.sayHello("홍길동"));
	}
}
