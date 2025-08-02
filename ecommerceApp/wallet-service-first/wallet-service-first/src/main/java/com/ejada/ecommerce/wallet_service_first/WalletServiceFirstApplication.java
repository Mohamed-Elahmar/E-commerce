package com.ejada.ecommerce.wallet_service_first;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class WalletServiceFirstApplication {

	public static void main(String[] args) {
		SpringApplication.run(WalletServiceFirstApplication.class, args);
	}

}
