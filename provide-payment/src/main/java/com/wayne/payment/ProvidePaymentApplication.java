package com.wayne.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.wayne.payment","com.wayne.utils"})
public class ProvidePaymentApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProvidePaymentApplication.class, args);
	}

}
