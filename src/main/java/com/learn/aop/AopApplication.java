package com.learn.aop;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AopApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(AopApplication.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);
	}

}
