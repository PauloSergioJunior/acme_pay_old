package br.com.acme_pay.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Data
public class Transaction {

    private UUID transactionId;
    private BigDecimal transactionValue;
    private Account destinationAccount;
    private Account originAccount;
    private LocalDate transactionDate;
    private Integer accountId;


}
