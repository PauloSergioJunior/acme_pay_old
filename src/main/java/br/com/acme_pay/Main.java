package br.com.acme_pay;

import br.com.acme_pay.controller.CustomerController;
import br.com.acme_pay.controller.TransactionController;
import br.com.acme_pay.application.domain.models.Account;
import br.com.acme_pay.application.domain.models.Customer;
import br.com.acme_pay.application.domain.models.Transaction;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        //transaction();
        //customer();

        Customer c = new Customer();
        Customer c2 = new Customer();
        c2.setCustomerAccounts(new ArrayList<>());
        c2.setCustomerName("Paulo");
        c2.setCustomerDocument("12345678910");
        c2.setCustomerPassword("123");
        c2.setCustomerEmail("email@email");
        c2.setCustomerPhone("888888888");
        c2.setCustomers(new ArrayList<>());

        System.out.println(c.created(c2).toString());
        System.out.println(c.created(c2).toString());
        System.out.println(c.listCustomer());

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