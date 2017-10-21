package pl.my.quickcash.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pl.my.quickcash.data.client.Client;
import pl.my.quickcash.data.client.ClientAccount;
import pl.my.quickcash.data.client.ClientKey;
import pl.my.quickcash.data.employee.EmployeeKey;

import java.util.List;

public class ClientKeyDAO {

    private SqlSessionFactory sqlSessionFactory = null;

    public ClientKeyDAO(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @SuppressWarnings("unchecked")
    public String getLoginFromMySQL (String login) {
        String log = null;
        ClientKey clientKey = null;
        SqlSession session = sqlSessionFactory.openSession();

        try {
            try {
                if (!session.selectOne("ClientKey.selectLogin", login).equals(null)) {
                    clientKey = session.selectOne("ClientKey.selectLogin", login);
                    log = login;
                }
            }catch (NullPointerException e) {
                System.out.println(e.getMessage());
            }
        } finally {
            session.close();
        }
        System.out.println(log);
        return log;
    }

    public String getPasswordFromMySQL (String password) {
        String pass = null;
        ClientKey clientKey = null;
        SqlSession session = sqlSessionFactory.openSession();

        try {
            try {
                if (!session.selectOne("ClientKey.selectPassword", password).equals(null)) {
                    clientKey = session.selectOne("ClientKey.selectPassword", password);
                    pass = password;
                }
            }catch (NullPointerException x) {
                System.out.println(x.getMessage());
            }
        } finally {
            session.close();
        }
        System.out.println(pass);
        return pass;
    }
}