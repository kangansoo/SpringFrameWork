package springFw.ex04.aop01;

import org.springframework.stereotype.Service;

import ch.qos.logback.core.net.SyslogOutputStream;

@Service
public class HelloService implements IHelloService {
	
	@Override
	public String sayHello(String name) {
//		System.out.println(">>>log"+ new java.util.Date());
		

		System.out.println("HelloService.sayHello() 메서드 실행");
		String message = "Hello~~~" + name;
		return message;
	}


}
