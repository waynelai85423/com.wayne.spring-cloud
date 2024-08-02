package com.wayne.payment.jpa;

import com.wayne.api.payment.Payment;
import com.wayne.api.payment.PaymentRequest;
import com.wayne.payment.entities.PaymentEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

import java.util.List;

import static org.mapstruct.CollectionMappingStrategy.TARGET_IMMUTABLE;
import static org.mapstruct.NullValueMappingStrategy.RETURN_DEFAULT;

@Mapper(componentModel = "spring", collectionMappingStrategy = TARGET_IMMUTABLE, nullValueMappingStrategy = RETURN_DEFAULT, builder = @Builder)
public interface PaymentMapper {


    PaymentEntity toJpa(PaymentRequest paymentRequest);

    Payment fromJpa(PaymentEntity paymentEntity);

    List<Payment> fromJpa(List<PaymentEntity> paymentEntities);

}
