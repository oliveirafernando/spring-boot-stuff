package com.oliveirafernando;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.oliveirafernando.config.property.AppApiProperty;
import com.oliveirafernando.security.util.PasswordGenerator;

@SpringBootApplication
@EnableConfigurationProperties(AppApiProperty.class)
public class SpringbootAngularApiApplication {

	public static void main(String[] args) {
//		System.out.println(PasswordGenerator.generate("admin"));
		
		SpringApplication.run(SpringbootAngularApiApplication.class, args);
	}
}
