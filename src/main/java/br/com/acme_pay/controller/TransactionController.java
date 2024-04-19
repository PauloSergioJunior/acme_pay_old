package br.com.acme_pay.controller;

import br.com.acme_pay.model.Transaction;
import br.com.acme_pay.service.TransactionService;

public class TransactionController {

    //private TransactionService transactionService;

    public String makeTransaction(Transaction transaction){
        TransactionService transactionService = new TransactionService();

        System.out.println(transactionService.calculateRate(transaction).doubleValue());

        return transactionService.checkBalance(transaction).toString();

    }

}
