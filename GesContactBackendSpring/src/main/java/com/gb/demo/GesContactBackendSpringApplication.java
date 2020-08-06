package com.gb.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gb.demo.dao.ContactRepository;

@SpringBootApplication
public class GesContactBackendSpringApplication  {

	//@Autowired
	//ContactRepository ca;
	public static void main(String[] args) {
		SpringApplication.run(GesContactBackendSpringApplication.class, args);
	}
     
	/* @Override
	public void run(String... args) throws Exception {
		Contact c=new Contact();
		c.setNom("Gaye");
		c.setPrenom("Birane");
		c.setTel(772389534);
		c.setDateNaissance(null);
		c.setPhoto(null);
		ca.save(c);
		System.out.println(ca.save(c));
		
	}*/
}
