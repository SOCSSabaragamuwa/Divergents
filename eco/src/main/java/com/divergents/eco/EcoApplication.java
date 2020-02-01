package com.divergents.eco;

import com.divergents.eco.model.repository.UserJdbcRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;




@SpringBootApplication
public class EcoApplication  {


    @Autowired
    UserJdbcRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(EcoApplication.class, args);
	}


}
