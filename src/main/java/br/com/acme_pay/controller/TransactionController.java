package br.com.acme_pay.controller;

import br.com.acme_pay.enums.ClientBalanceStatus;
import br.com.acme_pay.enums.TransferStatus;
import br.com.acme_pay.model.Transaction;
import br.com.acme_pay.service.TransactionService;

public class TransactionController {

    //private TransactionService transactionService;

    public Enum<?> makeTransaction(Transaction transaction){
        TransactionService transactionService = new TransactionService();
        Enum<ClientBalanceStatus> clientBalanceStatusEnum = transactionService.checkBalance(transaction);

        if (clientBalanceStatusEnum != ClientBalanceStatus.WITH_BALANCE) {
            return clientBalanceStatusEnum;
        }

        System.out.println(transaction.toString());
        transactionService.calculateTransfer(transaction);
        System.out.println(transaction.toString());

        return TransferStatus.APPROVED;

    }

}
