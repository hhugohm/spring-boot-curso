package com.neosunivesity.springboot.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication //@ComponetScan ya esta definido para com.neosunivesity.springboot.web
@ComponentScan("com.neosunivesity") //Solo se ocupa si se va a scanear en diferente paquete
public class SpringBootFirstWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootFirstWebApplication.class, args);
	}
}
