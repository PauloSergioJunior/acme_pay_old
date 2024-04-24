package br.com.acme_pay.controller;

import br.com.acme_pay.enums.CustomerBalanceStatus;
import br.com.acme_pay.enums.TransferStatus;
import br.com.acme_pay.domain.Transaction;
import br.com.acme_pay.service.TransactionService;

import java.util.Optional;

public class TransactionController {

    //private TransactionService transactionService;
    //private

    public Enum<?> makeTransaction(Transaction transaction){

        TransactionService transactionService = new TransactionService();
        Enum<CustomerBalanceStatus> clientBalanceStatusEnum = transactionService.checkBalance(transaction);

        if (clientBalanceStatusEnum != CustomerBalanceStatus.WITH_BALANCE) {
            return clientBalanceStatusEnum;
        }else if (!transactionService.checkTypeAccount(transaction)){
            return TransferStatus.REJECTED;
        }

        System.out.println(transaction.toString());

        System.out.println(transaction.toString());

        return transactionService.calculateTransfer(transaction);

    }

}
