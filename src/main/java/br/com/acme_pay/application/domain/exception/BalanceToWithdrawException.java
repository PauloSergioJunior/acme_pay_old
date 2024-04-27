package br.com.acme_pay.application.domain.exception;

public class BalanceToWithdrawException extends Exception{

    public BalanceToWithdrawException(String menssage){
        super(menssage);
    }
}
