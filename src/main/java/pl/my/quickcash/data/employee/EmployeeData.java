package pl.my.quickcash.data.employee;

import java.math.BigInteger;

public class EmployeeData {

    private String firstName;
    private String lastName;
    private String position;
    private BigInteger employee_key_id;

    public EmployeeData(String firstName, String lastName, String position) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
    }

    public EmployeeData(String firstName, String lastName, String position, BigInteger employee_key_id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.employee_key_id = employee_key_id;
    }

    public EmployeeData() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public BigInteger getEmployee_key_id() {
        return employee_key_id;
    }

    public void setEmployee_key_id(BigInteger employee_key_id) {
        this.employee_key_id = employee_key_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeeData that = (EmployeeData) o;

        if (!firstName.equals(that.firstName)) return false;
        if (!lastName.equals(that.lastName)) return false;
        if (!position.equals(that.position)) return false;
        return employee_key_id.equals(that.employee_key_id);
    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + position.hashCode();
        result = 31 * result + employee_key_id.hashCode();
        return result;
    }

    @Override
    public String toString() {
        StringBuilder print = new StringBuilder(32);
        print.append(firstName);
        print.append("; ");
        print.append(lastName);
        print.append("; ");
        print.append(position);
        print.append("; ");
        return print.toString();
    }
}
