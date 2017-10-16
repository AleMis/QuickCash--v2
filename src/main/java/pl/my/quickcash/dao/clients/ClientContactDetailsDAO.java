package pl.my.quickcash.dao.clients;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pl.my.quickcash.data.client.ClientContactDetails;
import pl.my.quickcash.data.client.ClientKey;
import pl.my.quickcash.data.client.ClientPersonalData;

import java.util.List;

public class ClientContactDetailsDAO {

    private SqlSessionFactory sqlSessionFactory = null;

    public ClientContactDetailsDAO(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @SuppressWarnings("unchecked")
    public ClientContactDetails selectClientContactDetails(int client_key_id) {
        ClientContactDetails clientContactDetails = null;
        SqlSession session = sqlSessionFactory.openSession();

        try {
            clientContactDetails = session.selectOne("ClientContactDetails.selectClientContactDetails", client_key_id);
        } finally {
            session.close();
        }
        return clientContactDetails;
    }

    public void updateClientContactDetails(ClientContactDetails clientContactDetails) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.update("ClientContactDetails.updateClientContactDetails", clientContactDetails);
        } finally {
            session.commit();
            session.close();
        }
    }

    public List<ClientContactDetails> selectAllClientContactDetails() {
        List<ClientContactDetails> list = null;
        SqlSession session = sqlSessionFactory.openSession();

        try {
            list = session.selectList("ClientContactDetails.selectAllClientContactDetails");
        } finally {
            session.close();
        }
        return list;
    }

    public void insertClientContactDetails(ClientContactDetails clientContactDetails) {
        SqlSession session = sqlSessionFactory.openSession();

        try {
            session.insert("ClientContactDetails.insertClientContactDetails", clientContactDetails);
        } finally {
            session.commit();
            session.close();
        }
    }
}
