package br.com.acme_pay.domain;

import br.com.acme_pay.enums.AccountType;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class Account {

    private Integer accountNumber;
    private Integer agencyNumber;
    private BigDecimal balance;
    private Enum<AccountType> accountType;


}
