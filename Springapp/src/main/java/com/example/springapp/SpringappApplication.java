package com.example.springapp;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;
import com.example.springapp.model.Role;
import com.example.springapp.repository.RoleRepository;
import java.util.Arrays;
import org.springframework.boot.ApplicationRunner;

@SpringBootApplication
public class SpringappApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringappApplication.class, args);
	}
	@Bean
	public ApplicationRunner initializer(RoleRepository roleRepository) 
	{
		return args -> roleRepository.saveAll(Arrays.asList(
				Role.builder().roleName("USER").roleDescription("Default Role provided to each user").build(),
				Role.builder().roleName("ADMIN").roleDescription("Superuser, who has access for all functionality").build()));
	}

}
