package br.com.acme_pay.controller;

import br.com.acme_pay.enums.CustomerCreationStatus;
import br.com.acme_pay.model.Customer;
import br.com.acme_pay.service.CustomerService;

public class CustomerController {


    public Enum<CustomerCreationStatus> registerClient(Customer customer){
        CustomerService service = new CustomerService();

       return service.createCustomer(customer) != null
               ? CustomerCreationStatus.COMPLETED
               : CustomerCreationStatus.FAILED;
    }
}
