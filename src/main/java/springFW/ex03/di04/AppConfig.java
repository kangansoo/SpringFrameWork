package springFw.ex03.di04;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@Configurable
@ComponentScan(basePackages= {"springFw.ex03.di03"})
public class AppConfig {
	

	
}
