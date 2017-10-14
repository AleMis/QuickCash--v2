package pl.my.quickcash.dao.employee;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import pl.my.quickcash.data.employee.EmployeeKey;


import java.util.List;

public class EmployeeKeyDAO {

    private SqlSessionFactory sqlSessionFactory = null;

    public EmployeeKeyDAO(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @SuppressWarnings("unchecked")
    public List<EmployeeKey> selectEmployeeKey() {
        List<EmployeeKey> list = null;
        SqlSession session = sqlSessionFactory.openSession();

        try {
            list = session.selectList("EmployeeKey.selectLoginAndPassword");
        } finally {
            session.close();
        }
        System.out.println("selectLoginAndPassword() --> " + list);
        return list;
    }
}
