package com.example.spinrgrest_yonghua;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude=HibernateJpaAutoConfiguration.class)
public class SpinrgRestYonghuaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpinrgRestYonghuaApplication.class, args);
	}

}
