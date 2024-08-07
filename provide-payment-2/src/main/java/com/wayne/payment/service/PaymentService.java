package com.wayne.payment.service;


import com.wayne.api.payment.Payment;
import com.wayne.api.payment.PaymentRequest;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface PaymentService {

    Payment create(PaymentRequest paymentRequest);

     Payment getPaymentById(@Param("id") Long id);

    List<Payment> getPaymentAll();
}
