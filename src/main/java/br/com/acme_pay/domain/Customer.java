package br.com.acme_pay.domain;

import br.com.acme_pay.exception.CustomerDeleteException;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {

    private Long id;
    private String customerDocument;
    private List<Account> customerAccounts;
    private String customerName;
    private String customerEmail;
    private String customerPhone;
    private String customerPassword;

    private List<Customer> customers = new ArrayList<>();


    public Customer created(Customer customer){
        Customer cs = new Customer();
        cs.setCustomerEmail(customer.getCustomerEmail());
        cs.setCustomerName(customer.getCustomerName());
        cs.setCustomerPhone(customer.getCustomerPhone());
        cs.setCustomerPassword(customer.getCustomerPassword());
        cs.setCustomerDocument(customer.getCustomerDocument());
        cs.setCustomers(customer.getCustomers());
        cs.setCustomerAccounts(new ArrayList<>());
        this.customers.add(cs);
        return cs;
    }

    public List<Customer> listCustomer(){

        return this.customers.stream().toList();

    }

    public void deleteCustumer(String document) throws CustomerDeleteException {


        if (!valudDocument(document)){
            this.customers.remove(getByCustumerDocument(document));
        }else {
            throw new CustomerDeleteException("error delete");
        }
    }

    public Customer getByCustumerDocument(String document){

       return this.customers.stream()
               .filter(c -> c.getCustomerDocument().equals(document))
               .findFirst()
               .get();


    }

    private boolean valudEmail(String email){

        return this.customers.stream()
                .anyMatch(c -> c.getCustomerEmail().equals(email));

    }

    private boolean valudDocument(String document){

        return this.customers.stream()
                .anyMatch(c -> c.getCustomerDocument().equals(document));

    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", customerDocument='" + customerDocument + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", customerPhone='" + customerPhone + '\'' +
                ", customerPassword='" + customerPassword + '\'' +
                ", customers=" + customers.toString() +
                '}';
    }
}
