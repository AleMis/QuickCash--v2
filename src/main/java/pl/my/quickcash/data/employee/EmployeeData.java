package pl.my.quickcash.data.employee;

import java.math.BigInteger;

public class EmployeeData {

    private String firstName;
    private String lastName;
    private String position;
    private BigInteger employeeKeyId;

    public EmployeeData(String firstName, String lastName, String position) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
    }

    public EmployeeData(String firstName, String lastName, String position, BigInteger employeeKeyId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.employeeKeyId = employeeKeyId;
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

    public BigInteger getEmployeeKeyId() {
        return employeeKeyId;
    }

    public void setEmployeeKeyId(BigInteger employeeKeyId) {
        this.employeeKeyId = employeeKeyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeeData that = (EmployeeData) o;

        if (!firstName.equals(that.firstName)) return false;
        if (!lastName.equals(that.lastName)) return false;
        if (!position.equals(that.position)) return false;
        return employeeKeyId.equals(that.employeeKeyId);
    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + position.hashCode();
        result = 31 * result + employeeKeyId.hashCode();
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
