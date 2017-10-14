package pl.my.quickcash.dao.clients;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pl.my.quickcash.data.client.ClientAccount;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ClientAccountDAO {

    private SqlSessionFactory sqlSessionFactory = null;

    public ClientAccountDAO(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @SuppressWarnings("unchecked")
    public List<ClientAccount> selectClientAccount() {
        List<ClientAccount> list = null;
        SqlSession session = sqlSessionFactory.openSession();

        try {
            list = session.selectList("ClientAccount.selectClientAccount");
        } finally {
            session.close();
        }
        System.out.println("selectClientAccount() --> " + list);
        return list;
    }
}
