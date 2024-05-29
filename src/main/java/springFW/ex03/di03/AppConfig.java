package springFW.ex03.di03;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@Configurable
@ComponentScan(basePackages= {"springFw.ex03.di03"})
public class AppConfig {
	
	@Bean
	IHelloService helloService() {
		return new HelloService();
	}
	
}
