package br.com.acme_pay.service;

import br.com.acme_pay.enums.ClientBalanceStatus;
import br.com.acme_pay.model.Account;
import br.com.acme_pay.model.Transaction;

import java.math.BigDecimal;

public class TransactionService {


    public ClientBalanceStatus checkBalance(Transaction transaction){

        BigDecimal balanceAccount = transaction.getOriginAccount().getBalance();
        BigDecimal valueTransaction = transaction.getTransactionValue();

        return balanceAccount.compareTo(BigDecimal.ZERO) == 0
                ? ClientBalanceStatus.WITHOUT_BALANCE
                : balanceAccount.compareTo(valueTransaction) < 0
                ? ClientBalanceStatus.INSUFFICIENT_BALANCE
                : ClientBalanceStatus.WITH_BALANCE;

    }

    public BigDecimal calculateRate(Transaction transaction){

        Integer agencyOrigin = transaction.getOriginAccount().getAgencyNumber();
        Integer agencyDestination = transaction.getDestinationAccount().getAgencyNumber();

        double percentage = 1.0;

        return agencyOrigin.intValue() != agencyDestination.intValue()
                ? new BigDecimal(percentage / 100).multiply(transaction.getTransactionValue())
                : BigDecimal.ZERO;


    }

}
