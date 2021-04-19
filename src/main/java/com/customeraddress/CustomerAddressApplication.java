package com.customeraddress;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CustomerAddressApplication {
	public static void main(String[] args) {
		SpringApplication.run(CustomerAddressApplication.class, args);
	}
}
