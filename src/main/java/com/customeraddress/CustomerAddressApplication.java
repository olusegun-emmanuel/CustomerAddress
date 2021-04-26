package com.customeraddress;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.boot.SpringApplication;

@SpringBootApplication
@EnableEurekaClient
public class CustomerAddressApplication {
	public static void main(String[] args) {
		SpringApplication.run(CustomerAddressApplication.class, args);
	}
}
