package com.guigui.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "com")
@ComponentScan(basePackages = {"com.guigui.springboot.controller","com.guigui.springboot.dao","com.guigui.springboot.model","com.guigui.springboot.service","com.guigui.springboot.web"})
public class VhrSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(VhrSpringbootApplication.class, args);
	}

}
