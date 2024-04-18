package br.com.acme_pay.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Account {

    private Integer accountNumber;
    private Integer agencyNumber;
    private BigDecimal balance;


}
