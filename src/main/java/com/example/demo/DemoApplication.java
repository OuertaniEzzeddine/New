package com.example.demo;

import com.example.demo.AboutEvent.Models.Facture;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

@SpringBootApplication
@EnableJpaRepositories("com.*")
@EntityScan("com.*")
public class DemoApplication {
	//



	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Facture f=new Facture(scanner);
		System.out.println(f.getContenu());
		//SpringApplication.run(DemoApplication.class, args);
	}


}
