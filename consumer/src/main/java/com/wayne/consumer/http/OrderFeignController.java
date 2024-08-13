package com.wayne.consumer.http;



import com.wayne.api.payment.Payment;
import com.wayne.api.payment.PaymentRequest;
import com.wayne.api.utils.CommonResult;
import com.wayne.consumer.service.PaymentFeignService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "消費者 API")
@Slf4j
@RestController
@RequestMapping("/consumer")
@RequiredArgsConstructor()
public class OrderFeignController {


    private final PaymentFeignService paymentFeignService;

    @Operation(summary = "查詢支付")
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return paymentFeignService.getPaymentById(id);
    }

    @Operation(summary = "查詢全部")
    @GetMapping(value = "/payment/all")
    public CommonResult<List<Payment>> getPaymentAll() {
        return paymentFeignService.getPaymentAll();
    }

    @Operation(summary = "創建支付")
    @PostMapping("/payment/feign/create")
    public CommonResult<Payment> paymentFeignCreate(@RequestBody PaymentRequest paymentRequest) {
        return paymentFeignService.create(paymentRequest);
    }

    @Operation(summary = "錯誤測試")
    @GetMapping("/error")
    public void errorTest() {
        throw new IllegalArgumentException("錯誤測試");
    }

    @Operation(summary = "TimeOut測試")
    @GetMapping("/timeOutTest")
    public void timeOutTest() {
        try {
            log.info("TimeOut測試");
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Operation(summary = "springCloudConfigTest")
    @GetMapping(value = "/springCloudConfigTestl")
    public String springCloudConfigTest() {
        return paymentFeignService.springCloudConfigTest();
    }

}
