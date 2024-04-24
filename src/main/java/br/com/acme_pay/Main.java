package br.com.acme_pay;

import br.com.acme_pay.controller.CustomerController;
import br.com.acme_pay.controller.TransactionController;
import br.com.acme_pay.enums.AccountType;
import br.com.acme_pay.domain.Account;
import br.com.acme_pay.domain.Customer;
import br.com.acme_pay.domain.Transaction;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        //transaction();
        customer();

    }

    private static void customer() {
        CustomerController controller = new CustomerController();
        Customer customer = Customer.builder()
                .customerName("Paul")
                .customerEmail("P@email")
                .customerDocument("12345678")
                .customerAccounts(null)
                .customerPassword("123")
                .customerPhone("12312312")
                .build();

        System.out.println(controller.registerClient(customer));
    }

    private static void transaction() {
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