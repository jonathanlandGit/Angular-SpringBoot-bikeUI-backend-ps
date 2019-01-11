package com.globomatics.bike;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * Same as @Configuration @EnableAutoConfiguration @ComponentScan
 * Many Spring Boot developers like their apps to use auto-configuration, component scan and be able to define extra configuration on their "application class". A single @SpringBootApplication annotation can be used to enable those three features, that is:
 * @EnableAutoConfiguration: enable Spring Boot’s auto-configuration mechanism
 * @ComponentScan: enable @Component scan on the package where the 
 * application is located (see the best practices)
 * @Configuration: allow to register extra beans in the context or 
 * import additional configuration classes
 */

@SpringBootApplication
public class BikeApplication {

	public static void main(String[] args) {
		SpringApplication.run(BikeApplication.class, args);
	}
}
