package com.parth.App;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.parth.Registration","com.parth.User","com.parth.Events"})
@ComponentScan(basePackages = {"com.parth.Registration","com.parth.User","com.parth.Events"})
@EntityScan(basePackages = {"com.parth.Registration","com.parth.User","com.parth.Events"})
@EnableJpaRepositories({"com.parth.Registration","com.parth.User","com.parth.Events"})
public class RegistrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistrationApplication.class, args);
	}
}
