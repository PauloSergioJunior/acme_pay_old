package br.com.acme_pay.service;

import br.com.acme_pay.enums.ClientType;
import br.com.acme_pay.model.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
                        .clientType(ClientType.COMMON_CUSTOMER)
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
                               .clientType(ClientType.COMMON_CUSTOMER)
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
