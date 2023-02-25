package com.example.login;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
// Bean là gì ? là các Spring IoC container
// 1. Đánh dấu lên Class (@Componet , @Controller , ...)
// 2. Đánh dấu lên Method
public class LoginUserApplication {




	public static void main(String[] args) {
		 SpringApplication.run(LoginUserApplication.class, args);
	}
}
