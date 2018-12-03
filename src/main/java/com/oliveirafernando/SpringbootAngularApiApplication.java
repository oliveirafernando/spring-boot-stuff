package com.oliveirafernando;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.oliveirafernando.config.property.AppApiProperty;

@SpringBootApplication
@EnableConfigurationProperties(AppApiProperty.class)
public class SpringbootAngularApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootAngularApiApplication.class, args);
	}
}
