package com.wayne.payment.service.impl;


import com.wayne.api.payment.Payment;
import com.wayne.api.payment.PaymentRequest;
import com.wayne.payment.jpa.PaymentMapper;
import com.wayne.payment.jpa.PaymentRepository;
import com.wayne.payment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
@Transactional(rollbackFor = Exception.class)
@Slf4j
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    private final PaymentMapper paymentMapper;

    @Override
    public Payment create(PaymentRequest paymentRequest) {

        return paymentMapper.fromJpa(paymentRepository.save(paymentMapper.toJpa(paymentRequest)));
    }

    @Override
    public Payment getPaymentById(Long id) {

        return paymentMapper.fromJpa(paymentRepository.findById(id).orElse(null));
    }

    @Override
    public List<Payment> getPaymentAll() {
        int i = 100/ 0;
        return paymentMapper.fromJpa(paymentRepository.findAll());
    }


}
