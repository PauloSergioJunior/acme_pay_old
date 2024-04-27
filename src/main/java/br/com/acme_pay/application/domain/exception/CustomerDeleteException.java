package br.com.acme_pay.application.domain.exception;

public class CustomerDeleteException extends Exception{

    public CustomerDeleteException(String menssage){
        super(menssage);
    }
}
