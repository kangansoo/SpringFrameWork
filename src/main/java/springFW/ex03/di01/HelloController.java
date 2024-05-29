package springFW.ex03.di01;

public class HelloController {
	//IHelloService hello = new HelloService();
	//HelloService에 의존성이 생김
	
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
