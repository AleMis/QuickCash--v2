package pl.my.quickcash.dao.clients;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pl.my.quickcash.data.client.ClientKey;
import pl.my.quickcash.data.client.ClientPersonalData;

import java.util.List;

public class ClientPersonalDataDAO {

    private SqlSessionFactory sqlSessionFactory = null;

    public ClientPersonalDataDAO(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @SuppressWarnings("unchecked")
    public List<ClientPersonalData> selectClientPersonalData() {
        List<ClientPersonalData> list = null;
        SqlSession session = sqlSessionFactory.openSession();

        try {
            list = session.selectList("ClientPersonalData.selectClientPersonalData");
        } finally {
            session.close();
        }
        System.out.println("selectClientPersonalData() --> " + list);
        return list;
    }
}
