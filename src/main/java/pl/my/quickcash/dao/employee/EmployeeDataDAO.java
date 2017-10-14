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
    public List<EmployeeData> selectEmployeeData() {
        List<EmployeeData> list = null;
        SqlSession session = sqlSessionFactory.openSession();

        try {
            list = session.selectList("EmployeeData.selectEmployeeData");
        }finally {
            session.close();
        }
        System.out.println("selectEmployeeData() --> " + list);
        return list;
    }

}
