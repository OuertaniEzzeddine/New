package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@SpringBootApplication
@EnableJpaRepositories("com.*")
@EntityScan("com.*")
public class DemoApplication {
	//



<<<<<<< Updated upstream
	public static void main(String[] args) {SpringApplication.run(DemoApplication.class, args);}
=======
	public static void main(String[] args) {
		
		SpringApplication.run(DemoApplication.class, args);
	}
>>>>>>> Stashed changes


}
