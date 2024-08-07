package com.wayne.api.payment;

import com.wayne.utils.AuditingBase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;


@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequest  extends AuditingBase<String> implements Serializable {

    private String serial;

    private String status;
}
