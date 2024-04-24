package br.com.acme_pay.service;

import br.com.acme_pay.enums.CustomerBalanceStatus;
import br.com.acme_pay.domain.Transaction;
import br.com.acme_pay.enums.AccountType;
import br.com.acme_pay.enums.TransferStatus;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TransactionService {


    public CustomerBalanceStatus checkBalance(Transaction transaction){

        if (checkValuesTransaction(transaction)) {

            BigDecimal balanceAccount = transaction.getOriginAccount().getBalance();
            BigDecimal valueTransaction = transaction.getTransactionValue();

            return balanceAccount.compareTo(BigDecimal.ZERO) == 0
                    ? CustomerBalanceStatus.WITHOUT_BALANCE
                    : balanceAccount.compareTo(valueTransaction) < 0
                    ? CustomerBalanceStatus.INSUFFICIENT_BALANCE
                    : CustomerBalanceStatus.WITH_BALANCE;
        }

        return CustomerBalanceStatus.WITHOUT_BALANCE;

    }

    public BigDecimal calculateRate(Transaction transaction){

        Integer agencyOrigin = transaction.getOriginAccount().getAgencyNumber();
        Integer agencyDestination = transaction.getDestinationAccount().getAgencyNumber();

        double percentage = 1.0;

        return agencyOrigin.intValue() != agencyDestination.intValue()
                ? new BigDecimal(percentage / 100).multiply(transaction.getTransactionValue())
                : BigDecimal.ZERO;


    }

    public Enum<TransferStatus> calculateTransfer(Transaction transaction){

        if (checkValuesTransaction(transaction)) {

            BigDecimal balanceOriginAccount = transaction.getOriginAccount().getBalance();
            BigDecimal balanceDestinationAccount = transaction.getDestinationAccount().getBalance();
            BigDecimal transactionValue = transaction.getTransactionValue();

            transaction.getOriginAccount()
                    .setBalance(balanceOriginAccount
                            .subtract(transactionValue
                                    .add(calculateRate(transaction))
                                    .setScale(2, RoundingMode.HALF_UP)));

            transaction.getDestinationAccount()
                    .setBalance(balanceDestinationAccount
                            .add(transactionValue));

            return TransferStatus.APPROVED;

        }

        return TransferStatus.REJECTED;
    }

    public boolean checkTypeAccount(Transaction transaction){

        if (checkValuesTransaction(transaction)) {

            Enum<AccountType> accountTypeOrigin = transaction.getOriginAccount().getAccountType();
            Enum<AccountType> accountTypeDestination = transaction.getDestinationAccount().getAccountType();

            return accountTypeOrigin.equals(accountTypeDestination);

        }
        return false;
    }

    private boolean checkValuesTransaction(Transaction transaction){
        return transaction != null
                && transaction.getOriginAccount() != null
                && transaction.getOriginAccount().getBalance() != null
                && transaction.getDestinationAccount() != null
                && transaction.getDestinationAccount().getBalance() != null
                && transaction.getTransactionValue() != null
                && transaction.getTransactionDate() != null
                && transaction.getOriginAccount().getAgencyNumber() != null
                && transaction.getDestinationAccount().getAgencyNumber() != null;
    }

}
