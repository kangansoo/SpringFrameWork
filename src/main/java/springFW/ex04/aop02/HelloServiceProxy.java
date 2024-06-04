package springFw.ex04.aop02;

public class HelloServiceProxy extends HelloService {

	@Override
	public String sayHello(String name) {
		HelloLog.log();
		
		String result = super.sayHello(name);
		
		return result;
	}

}
