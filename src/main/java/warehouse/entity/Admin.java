package warehouse.entity;

import javax.persistence.Entity;
import java.util.List;

@Entity
public class Admin extends User {
    private Double salary;

    public Admin(String userName, String password, List roles) {
        super(userName, password, roles);
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
