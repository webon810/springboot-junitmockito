package demo.springboot.junitmockito.demospringbootjunitmockito;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class WebApplication {
	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(WebApplication.class, args);
		for (String name: applicationContext.getBeanDefinitionNames()) {
			System.out.println(name);
		}
	}
}
