package pl.my.quickcash.dao.employee;

import pl.my.quickcash.dao.MyBatisConnectionFactory;
import pl.my.quickcash.data.employee.EmployeeData;
import pl.my.quickcash.data.employee.EmployeeKey;

import java.util.*;

public class EmployeeDatabaseDAO {

    private static HashMap<EmployeeKey, EmployeeData> employeesDatabase = null;

    private static EmployeeKeyDAO employeeKeyDAO = new EmployeeKeyDAO(MyBatisConnectionFactory.getSqlSessionFactory());
    private static EmployeeDataDAO employeeDataDAO = new EmployeeDataDAO(MyBatisConnectionFactory.getSqlSessionFactory());

//    static  {
//        List<EmployeeKey> keys = employeeKeyDAO.selectEmployeeKey();
//        List<EmployeeData> data = employeeDataDAO.selectEmployeeData();
//
//        System.out.println(keys);
//        System.out.println(data);
//
//        if (keys.size() != data.size())
//            throw new IllegalArgumentException ("Cannot combine lists with dissimilar sizes");
//        employeesDatabase = new LinkedHashMap<>();
//        for (int i=0; i<keys.size(); i++) {
//            employeesDatabase.put(keys.get(i), data.get(i));
//        }
//    }

    public static HashMap<EmployeeKey, EmployeeData> getInstance() {
        return employeesDatabase;
    }

}
