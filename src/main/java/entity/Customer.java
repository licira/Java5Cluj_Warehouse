package entity;

import javax.persistence.Entity;
import java.util.List;

@Entity
public class Customer extends User {
    private List orders;
    private String adress;
    private String iban;

    public Customer(String userName, String password, List roles) {
        super(userName, password, roles);
    }

    public List getOrders() {
        return orders;
    }

    public void setOrders(List orders) {
        this.orders = orders;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }
}
