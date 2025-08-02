package com.ejada.ecommerce.shop_service_second;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ShopServiceSecondApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopServiceSecondApplication.class, args);
	}

}
