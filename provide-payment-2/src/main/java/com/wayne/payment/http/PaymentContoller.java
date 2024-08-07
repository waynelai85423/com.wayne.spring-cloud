package com.wayne.payment.http;


import com.wayne.api.payment.Payment;
import com.wayne.api.payment.PaymentRequest;
import com.wayne.api.utils.CommonResult;
import com.wayne.payment.service.PaymentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Tag(name = "支付 REST API")
@Slf4j
@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
public class PaymentContoller {

    private final PaymentService paymentService;

    @Value("${server.port}")
    private  String serverPort ;

    @Operation(summary = "創建支付")
    @PostMapping(value = "/create")
    public CommonResult<Payment> create(@RequestBody PaymentRequest paymentRequest) {
        Payment payment = paymentService.create(paymentRequest);
        log.info("payment create result ,{}", payment);

        if (payment != null) {
            return new CommonResult(200, "success: " , payment);
        }

        return new CommonResult(444, "failure: " , null);
    }

    @Operation(summary = "查詢支付")
    @GetMapping(value = "/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {

        Payment result = paymentService.getPaymentById(id);
        log.info("payment query result is:,{} ", result);

        if (result != null) {
            return new CommonResult(200, "success: " , result);
        }
        return new CommonResult(444, "failure: " , null);
    }

    @Operation(summary = "查詢全部")
    @GetMapping(value = "/get/all")
    public CommonResult<List<Payment>> getPaymentAll() {

        List<Payment> results = paymentService.getPaymentAll();
        log.info("payment query result is:,{} ", results);

        if (results != null) {
            return new CommonResult(200, "success: "  + serverPort, results);
        }
        return new CommonResult(444, "failure: " , null);
    }
}
