package springFW.ex04.aop02;

import org.springframework.stereotype.Service;

import ch.qos.logback.core.net.SyslogOutputStream;

@Service
public class HelloService implements IHelloService {
	
	@Override
	public String sayHello(String name) {
		System.out.println("HelloService.sayHello() 메서드 실행");
		String message = "Hello~~~" + name;
		return message;
	}
	
	@Override
	public String sayGoodbye(String name) {
		System.out.println("HelloService.sayGoodbye() 메서드 실행");
		String message = "Goodbye~~~" + name;
		return message;
	}

}
