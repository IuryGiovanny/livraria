package my.company.livraria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(exclude = {org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
public class LivrariaApplication {
	public static void main(String[] args) {
		SpringApplication.run(LivrariaApplication.class, args);
	}
}
