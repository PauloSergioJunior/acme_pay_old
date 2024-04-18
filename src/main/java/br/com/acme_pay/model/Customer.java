package br.com.acme_pay.model;

import lombok.Data;

import java.util.List;

@Data
public class Customer {

    private String customerDocument;
    private List<Account> customerAccounts;
    private String customerName;
    private String customerEmail;
    private String customerPhone;

}
