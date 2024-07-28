package com.wayne.payment;

import com.google.common.collect.Maps;
import com.wayne.payment.entities.PaymentEntity;
import com.wayne.payment.jpa.PaymentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PaymentTest {

    @Autowired
    PaymentRepository paymentRepository;
    @Test
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Commit
    public void test(){
        Map<String,String> map = Maps.newHashMap();
        map.put("ex","32");
        PaymentEntity build = PaymentEntity.builder().status("test01").serial("wayne").extras(map).build();
        PaymentEntity save = paymentRepository.save(build);
        System.out.println(save);
    }
}
