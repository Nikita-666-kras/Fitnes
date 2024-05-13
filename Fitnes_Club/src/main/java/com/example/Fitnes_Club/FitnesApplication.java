package com.example.Fitnes_Club;
import com.example.Fitnes_Club.models.User;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class FitnesApplication {
	public static ApplicationContext context;
	public static User  currentUser = null;
	public static void main(String[] args) {
		SpringApplication.run(FitnesApplication.class, args);
	}

}
