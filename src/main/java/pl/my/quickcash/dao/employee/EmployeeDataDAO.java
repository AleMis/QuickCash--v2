package pl.my.quickcash.dao.employee;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pl.my.quickcash.data.employee.EmployeeData;

import java.util.List;

public class EmployeeDataDAO {

    private SqlSessionFactory sqlSessionFactory = null;

    public EmployeeDataDAO(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @SuppressWarnings("unchecked")
    public EmployeeData selectEmployeeData(int employee_key_id) {
        EmployeeData employeeData = null;
        SqlSession session = sqlSessionFactory.openSession();

        try {
            employeeData = session.selectOne("EmployeeData.selectEmployeeData", employee_key_id);
        }finally {
            session.close();
        }
        return employeeData;
    }

}
