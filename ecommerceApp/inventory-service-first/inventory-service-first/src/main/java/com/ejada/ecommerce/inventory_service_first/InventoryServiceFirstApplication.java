package com.ejada.ecommerce.inventory_service_first;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class InventoryServiceFirstApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceFirstApplication.class, args);
	}

}
