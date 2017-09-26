package pl.my.quickcash.data.employee;

public class EmployeeData {


    private String firstName;
    private String lastName;
    private String position;

    public EmployeeData(String firstName, String lastName, String position) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
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
