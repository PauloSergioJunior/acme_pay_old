package br.com.acme_pay.service;

import br.com.acme_pay.enums.AccountType;
import br.com.acme_pay.domain.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerService {

    private List<Customer> customers = new ArrayList<>() {
    };

    public CustomerService(){
        this.customers.add(Customer.builder()
                        .customerName("Paul")
                        .customerEmail("Paul@email")
                        .customerDocument("123456789")
                        .customerAccounts(null)
                        .customerPassword("123")
                        .customerPhone("12312312")
                        .build());
    }

    public Customer createCustomer(Customer customer) {

        if (customerExists(customer)) {

           Customer cust = Customer.builder()
                               .customerName(customer.getCustomerName())
                               .customerEmail(customer.getCustomerEmail())
                               .customerDocument(customer.getCustomerDocument())
                               .customerAccounts(customer.getCustomerAccounts())
                               .customerPassword(customer.getCustomerPassword())
                               .customerPhone(customer.getCustomerPhone())
                               .build();
           customers.add(cust);

              return cust;

            }

        return null;
    }

    public boolean customerExists(Customer customer) {

        String email = customer.getCustomerEmail();
        String document = customer.getCustomerDocument();

        return customers.stream()
                    .filter(c -> email.equalsIgnoreCase(c.getCustomerEmail())
                            || document.equalsIgnoreCase(c.getCustomerDocument()))
                    .toList()
                            .isEmpty();

    }


}
