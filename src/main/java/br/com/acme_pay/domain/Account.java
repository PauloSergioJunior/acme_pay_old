package br.com.acme_pay.domain;

import br.com.acme_pay.enums.AccountType;
import br.com.acme_pay.exception.BalanceToWithdrawException;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class Account {

    private Long id;
    private Integer accountNumber;
    private Integer agencyNumber;
    private BigDecimal balance;
    private Boolean close;
    private Customer customer;
    private List<Card> cards;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private Enum<AccountType> accountType;
    private List<String> transactions = new ArrayList<>();


    public void create(Account account) {
        this.setId(account.id);
        this.setCreated_at(LocalDateTime.now());
        this.setUpdated_at(null);
        this.setCustomer(new Customer());
        this.setCards(new ArrayList<>());
        this.setBalance(BigDecimal.ZERO);
        this.setAccountNumber(account.accountNumber);
        this.setAgencyNumber(account.agencyNumber);
        this.setClose(account.close);
        this.transactions.add("account created successfully " + LocalDateTime.now());
    }

    public void deposit(BigDecimal amount){
        this.balance = this.balance.add(amount);
        this.transactions.add("Deposit" +
                " Successfully " + amount.toString());
    }

    public void withdraw(BigDecimal amount) throws BalanceToWithdrawException{

        checkBalance(amount);
        this.balance = this.balance.subtract(amount);
        this.transactions.add("Withdraw Successfully " + amount.toString());

    }

    public void transfer(Account targetAccount, BigDecimal valueTranfer) throws BalanceToWithdrawException {
        this.withdraw(valueTranfer);
        targetAccount.deposit(valueTranfer);
        this.transactions.add("Transfer made successfully to the accounts " + this.accountNumber + " and " + this.accountNumber);
    }

    private void checkBalance(BigDecimal amount) throws BalanceToWithdrawException {
        if (this.balance.compareTo(amount) < 0){
            throw new BalanceToWithdrawException("error withdraw");
        }

    }

}
