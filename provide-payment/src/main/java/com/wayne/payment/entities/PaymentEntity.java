package com.wayne.payment.entities;

import com.wayne.utils.AbstractEntity;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;


@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PaymentEntity extends AbstractEntity<String> implements Serializable {

    private String serial;

    private String status;
}
