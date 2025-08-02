package com.ejada.ecommerce.shop_service_first;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ShopServiceFirstApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopServiceFirstApplication.class, args);
	}

}

