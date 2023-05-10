package com.apidemo1.apidemo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class Apidemo1Application {

	public static void main(String[] args) {
		SpringApplication.run(Apidemo1Application.class, args);
	}

}
