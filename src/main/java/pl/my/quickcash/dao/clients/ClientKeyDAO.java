package pl.my.quickcash.dao.clients;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pl.my.quickcash.data.client.ClientKey;
import pl.my.quickcash.data.employee.EmployeeKey;

import java.util.List;

public class ClientKeyDAO {

    private SqlSessionFactory sqlSessionFactory = null;

    public ClientKeyDAO(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @SuppressWarnings("unchecked")
    public List<ClientKey> selectClientKey() {
        List<ClientKey> list = null;
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
