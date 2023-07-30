package com.example.springapp;

<<<<<<< HEAD

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;
import com.example.springapp.model.Role;
import com.example.springapp.repository.RoleRepository;
import java.util.Arrays;
import org.springframework.boot.ApplicationRunner;

@SpringBootApplication
public class SpringappApplication {
=======
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringappApplication 
{
>>>>>>> cd20a07a8d17164e81677b15f295cacebc216f65

	public static void main(String[] args) {
		SpringApplication.run(SpringappApplication.class, args);
	}
<<<<<<< HEAD
	@Bean
	public ApplicationRunner initializer(RoleRepository roleRepository) 
	{
		return args -> roleRepository.saveAll(Arrays.asList(
				Role.builder().roleName("USER").roleDescription("Default Role provided to each user").build(),
				Role.builder().roleName("ADMIN").roleDescription("Superuser, who has access for all functionality").build()));
	}
=======
>>>>>>> cd20a07a8d17164e81677b15f295cacebc216f65

}
