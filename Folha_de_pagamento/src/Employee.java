import java.util.ArrayList;

public class Employee {

    String name;
    String address;
    String employee_type;
    int employee_id;
    String Payment_method;
    double value_per_hour;
    double wage;
    double comission;
    double sindicate;
    double money;


    public Employee(String name, String address, String employee_type, int employee_id, String Payment_method, double value_per_hour, double wage, double comission, double sindicate) {
        this.name = name;
        this.address = address;
        this.employee_type = employee_type;
        this.employee_id = employee_id;
        this.Payment_method = Payment_method;
        this.value_per_hour = value_per_hour;
        this.wage = wage;
        this.comission = comission;
        this.sindicate = sindicate;
    }

    public double getValue_per_hour() {
        return value_per_hour;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getEmployee_type() {
        return employee_type;
    }

    public void setEmployee_type(String employee_type) {
        this.employee_type = employee_type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
