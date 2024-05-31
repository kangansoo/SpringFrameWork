package springFW.ex04.aop01;

public class HelloServiceProxy extends HelloService {

	@Override
	public String sayHello(String name) {
		HelloLog.log();
		
		String result = super.sayHello(name);
		
		return result;
	}

}
