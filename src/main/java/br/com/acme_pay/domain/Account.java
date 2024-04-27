package br.com.acme_pay.domain;

import br.com.acme_pay.enums.AccountType;
import br.com.acme_pay.exception.BalanceToWithdrawException;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class Account {

    private Integer accountNumber;
    private Integer agencyNumber;
    private BigDecimal balance;
    private Enum<AccountType> accountType;

    public void deposit(BigDecimal amount){
        this.balance = this.balance.add(amount);
    }

    public void withdraw(BigDecimal amount) throws BalanceToWithdrawException{

        checkBalance(amount);
        this.balance = this.balance.subtract(amount);

    }

    public void transfer(Account targetAccount, BigDecimal valueTranfer) throws BalanceToWithdrawException {
        this.withdraw(valueTranfer);
        targetAccount.deposit(valueTranfer);
    }

    private void checkBalance(BigDecimal amount) throws BalanceToWithdrawException {
        if (this.balance.compareTo(amount) < 0){
            throw new BalanceToWithdrawException("error withdraw");
        }

    }


}
