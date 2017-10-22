package pl.my.quickcash;

import pl.my.quickcash.dao.CommunicationDAO;
import pl.my.quickcash.data.client.ClientKey;
import pl.my.quickcash.data.employee.EmployeeData;
import pl.my.quickcash.data.employee.EmployeeKey;
import pl.my.quickcash.password_security.SecurePassword;

import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class TestEmployee {

    private static final String GET_EMPLOYEE_KEY_BY_LOGIN = "EmployeeKey.selectEmployeeKey";
    private static final String INSERT_EMPLOYEE_KEY = "EmployeeKey.insertEmployeeKey";
    private static final String INSERT_EMPLOYEE_DATA = "EmployeeData.insertEmployeeData";

    public static void createTestClients() throws InvalidKeySpecException, NoSuchAlgorithmException {

        EmployeeKey employee1 = CommunicationDAO.selectByString(GET_EMPLOYEE_KEY_BY_LOGIN, "employee1");
        EmployeeKey employee2 = CommunicationDAO.selectByString(GET_EMPLOYEE_KEY_BY_LOGIN, "employee2");

        if (employee1 == null && employee2 == null) {
            createEmployee1();
            createEmployee2();
        } else if ((employee1 == null) && !(employee2 == null)) {
            createEmployee1();
        } else if (!(employee1 == null) && (employee2 == null)) {
            createEmployee2();
        }
    }

    private static void createEmployee1() throws InvalidKeySpecException, NoSuchAlgorithmException {
        String login = "employee1";
        String orginalPassword = "111";
        String securedPassword = SecurePassword.generateStrongPasswordHash(orginalPassword);

        EmployeeKey employeeKey = new EmployeeKey(login, securedPassword);
        CommunicationDAO.insert(INSERT_EMPLOYEE_KEY, employeeKey);

        EmployeeKey employee = CommunicationDAO.selectByString(GET_EMPLOYEE_KEY_BY_LOGIN, login);

        String firstName = "Marek";
        String lastName = "Nowacki";
        String position = "Key Account Manager";
        BigInteger employee_key_id = employee.getEmployee_key_id();

        EmployeeData employeeData = new EmployeeData(firstName, lastName, position,employee_key_id);

        CommunicationDAO.insert(INSERT_EMPLOYEE_DATA, employeeData);
    }

    private static void createEmployee2() throws InvalidKeySpecException, NoSuchAlgorithmException {
        String login = "employee2";
        String orginalPassword = "222";
        String securedPassword = SecurePassword.generateStrongPasswordHash(orginalPassword);

        EmployeeKey employeeKey = new EmployeeKey(login, securedPassword);
        CommunicationDAO.insert(INSERT_EMPLOYEE_KEY, employeeKey);

        EmployeeKey employee = CommunicationDAO.selectByString(GET_EMPLOYEE_KEY_BY_LOGIN, login);

        String firstName = "Darek";
        String lastName = "Darkowski";
        String position = "CEO";
        BigInteger employee_key_id = employee.getEmployee_key_id();

        EmployeeData employeeData = new EmployeeData(firstName, lastName, position,employee_key_id);

        CommunicationDAO.insert(INSERT_EMPLOYEE_DATA, employeeData);
    }
}
