package pl.my.quickcash.data;

import pl.my.quickcash.datamanagement.FileManager;

import java.io.IOException;
import java.util.HashMap;

public class EmployeesDatabase {

    private static HashMap<EmployeeKey, EmployeeData> employeesDatabase;

    static  {
        try {
            employeesDatabase =  FileManager.readEmployeesDatabaseFromFile();
            System.out.println("Employees data loaded to file!");
        } catch (IOException e) {
            employeesDatabase = new HashMap<EmployeeKey, EmployeeData>();
            System.out.println("New employees database was created!");
        }
    }

    public static HashMap<EmployeeKey, EmployeeData>   getInstance() {
        return employeesDatabase;
    }
}
