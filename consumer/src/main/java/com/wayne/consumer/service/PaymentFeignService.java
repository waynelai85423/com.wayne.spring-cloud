package com.wayne.consumer.service;



import com.wayne.api.payment.Payment;
import com.wayne.api.payment.PaymentRequest;
import com.wayne.api.utils.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Component
@FeignClient(name = "cloud-payment-service",path = "/payment")
public interface PaymentFeignService {

    @GetMapping(value = "/get/{id}")
     CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    @PostMapping(value = "/create")
     CommonResult<Payment> create(@RequestBody PaymentRequest paymentRequest);

    @GetMapping(value = "/get/all")
    CommonResult<List<Payment>> getPaymentAll();
}