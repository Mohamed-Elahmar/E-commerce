package com.ejada.ecommerce.wallet_service_second;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class WalletServiceSecondApplication {

	public static void main(String[] args) {
		SpringApplication.run(WalletServiceSecondApplication.class, args);
	}

}
