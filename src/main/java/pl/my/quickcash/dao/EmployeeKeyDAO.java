package pl.my.quickcash.dao;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pl.my.quickcash.data.employee.EmployeeKey;


public class EmployeeKeyDAO {

    private static SqlSessionFactory sqlSessionFactory = null;

    public EmployeeKeyDAO(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public String getLoginFromMySQL (String login) {
        String log = null;
        EmployeeKey employeeKey = null;
        SqlSession session = sqlSessionFactory.openSession();

        try {
            try {
                if (!session.selectOne("EmployeeKey.selectLogin", login).equals(null)) {
                    employeeKey = session.selectOne("EmployeeKey.selectLogin", login);
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
        EmployeeKey employeeKey = null;
        SqlSession session = sqlSessionFactory.openSession();

        try {
            try {
                if (!session.selectOne("EmployeeKey.selectPassword", password).equals(null)) {
                    employeeKey = session.selectOne("EmployeeKey.selectPassword", password);
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

    public EmployeeKey getEmployeeKey(String login) {
        EmployeeKey employeeKey = null;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            employeeKey = session.selectOne("EmployeeKey.selectEmployeeKey", login);
        } finally {
            session.close();
        }
        return employeeKey;
    }
}