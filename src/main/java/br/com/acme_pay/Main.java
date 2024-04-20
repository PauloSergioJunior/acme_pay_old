package br.com.acme_pay;

import br.com.acme_pay.controller.TransactionController;
import br.com.acme_pay.model.Account;
import br.com.acme_pay.model.Transaction;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        TransactionController controller = new TransactionController();

        Account account = new Account();
        account.setBalance(new BigDecimal(1200));
        //account.setBalance(BigDecimal.ZERO);
        account.setAgencyNumber(1234);

        Account accountDestination = new Account();
        accountDestination.setBalance(BigDecimal.ZERO);
        accountDestination.setAgencyNumber(1235);

        Transaction transaction = new Transaction();
        transaction.setOriginAccount(account);
        transaction.setTransactionValue(BigDecimal.valueOf(1000));
        transaction.setOriginAccount(account);

        transaction.setDestinationAccount(accountDestination);

        System.out.println(controller.makeTransaction(transaction).toString());

    }
}