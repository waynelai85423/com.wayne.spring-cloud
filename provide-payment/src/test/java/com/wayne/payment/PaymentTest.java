package com.wayne.payment;

import com.google.common.collect.Maps;
import com.wayne.api.payment.PaymentRequest;
import com.wayne.payment.entities.PaymentEntity;
import com.wayne.payment.jpa.PaymentMapper;
import com.wayne.payment.jpa.PaymentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PaymentTest {

    @Autowired
    PaymentRepository paymentRepository;

    @Autowired
    PaymentMapper paymentMapper;

    @Test
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Commit
    public void test(){
        Map<String,String> map = Maps.newHashMap();
        map.put("ex","61");
        PaymentRequest build1 = PaymentRequest.builder().status("true").serial("wayme").extras(map).build();
        PaymentEntity jpa = paymentMapper.toJpa(build1);
        PaymentEntity save = paymentRepository.save(jpa);
        System.out.println(save);
    }
}
