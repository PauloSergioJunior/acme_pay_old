package br.com.acme_pay.model;

import br.com.acme_pay.enums.ClientType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {

    private String customerDocument;
    private List<Account> customerAccounts;
    private String customerName;
    private String customerEmail;
    private String customerPhone;
    private String customerPassword;
    private Enum<ClientType> clientType;

}
