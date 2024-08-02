package com.wayne.payment;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(info = @Info(title = "Payment", version = "1.0.0", description = "支付項目"))
@SpringBootApplication(scanBasePackages = {"com.wayne.payment","com.wayne.utils"})
public class ProvidePaymentApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProvidePaymentApplication.class, args);
	}

}
