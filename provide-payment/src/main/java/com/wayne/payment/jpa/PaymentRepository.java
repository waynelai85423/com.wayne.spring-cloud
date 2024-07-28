package com.wayne.payment.jpa;

import com.wayne.payment.entities.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(rollbackFor = Exception.class)
@Repository
public interface PaymentRepository extends JpaRepository<PaymentEntity,Long>, JpaSpecificationExecutor<PaymentEntity> {

}
