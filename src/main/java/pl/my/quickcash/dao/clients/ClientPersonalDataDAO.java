package pl.my.quickcash.dao.clients;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pl.my.quickcash.data.client.Client;
import pl.my.quickcash.data.client.ClientContactDetails;
import pl.my.quickcash.data.client.ClientKey;
import pl.my.quickcash.data.client.ClientPersonalData;

import java.util.List;

public class ClientPersonalDataDAO {

    private SqlSessionFactory sqlSessionFactory = null;

    public ClientPersonalDataDAO(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @SuppressWarnings("unchecked")
    public ClientPersonalData selectClientPersonalData(int client_key_id) {
        ClientPersonalData clientPersonalData = null;
        SqlSession session = sqlSessionFactory.openSession();

        try {
            clientPersonalData = session.selectOne("ClientPersonalData.selectClientPersonalData", client_key_id);
        } finally {
            session.close();
        }
        return clientPersonalData;
    }

    public List<ClientPersonalData> selectAllClientPersonalData() {
        List<ClientPersonalData> list = null;
        SqlSession session = sqlSessionFactory.openSession();

        try {
            list = session.selectList("ClientPersonalData.selectAllClientPersonalData");
        } finally {
            session.close();
        }
        return list;
    }
}
