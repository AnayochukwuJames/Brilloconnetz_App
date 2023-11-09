package com.Java_Developer_Test.Brilloconnetz;

import com.Java_Developer_Test.Brilloconnetz.entity.User;
import com.Java_Developer_Test.Brilloconnetz.security.AppJwt;
import com.Java_Developer_Test.Brilloconnetz.service.UserServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BrilloconnetzApplication {


	public static void main(String[] args) {
		SpringApplication.run(BrilloconnetzApplication.class, args);
		User user = UserServiceImpl.getUserDetail();
           boolean validUser= UserServiceImpl.validateUser(user);
		System.out.println("User validation is: "+validUser);
		if (validUser) {
			System.out.println("This User Detail  "+user+" is valid");
			System.out.println("This is the generated JWT :" + AppJwt.generateToken(user.getUserName()));

			System.out.println("This jwt verified? " + AppJwt.verifyToken(AppJwt.generateToken(user.getUserName())));
		}else {
			System.out.println(UserServiceImpl.validateUser(user));
	}


}}

