package pl.my.quickcash.dao.clients;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pl.my.quickcash.data.client.ClientContactDetails;
import pl.my.quickcash.data.client.ClientPersonalData;

import java.util.List;

public class ClientContactDetailsDAO {

    private SqlSessionFactory sqlSessionFactory = null;

    public ClientContactDetailsDAO(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @SuppressWarnings("unchecked")
    public List<ClientContactDetails> selectClientContactDetails() {
        List<ClientContactDetails> list = null;
        SqlSession session = sqlSessionFactory.openSession();

        try {
            list = session.selectList("ClientContactDetails.selectClientContactDetails");
        } finally {
            session.close();
        }
        System.out.println("selectClientContactDetails() --> " + list);
        return list;
    }
}
