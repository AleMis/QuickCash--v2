package pl.my.quickcash.dao.clients;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pl.my.quickcash.data.client.Client;
import pl.my.quickcash.data.client.ClientAccount;
import pl.my.quickcash.data.client.ClientContactDetails;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ClientAccountDAO {

    private SqlSessionFactory sqlSessionFactory = null;

    public ClientAccountDAO(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @SuppressWarnings("unchecked")
    public ClientAccount selectClientAccount(int client_key_id) {
        ClientAccount clientAccount = null;
        SqlSession session = sqlSessionFactory.openSession();

        try {
            clientAccount = session.selectOne("ClientAccount.selectClientAccount", client_key_id);
        } finally {
            session.close();
        }
        return clientAccount;
    }

    public ClientAccount selectClientAccountByAccountNumber(String accountNumber) {
        ClientAccount clientAccount = null;
        SqlSession session = sqlSessionFactory.openSession();

        try {
            clientAccount = session.selectOne("ClientAccount.selectClientAccountByAccountNumber", accountNumber);
        } finally {
            session.close();
        }
        return clientAccount;
    }

    public void updateClientAccountBalance(ClientAccount clientAccount) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.update("ClientAccount.updateClientAccountBalance", clientAccount);
        } finally {
            session.commit();
            session.close();
        }
    }

    public List<ClientAccount> selectAllClientAccountB() {
        List<ClientAccount> list = null;
        SqlSession session = sqlSessionFactory.openSession();

        try {
            list = session.selectList("ClientAccount.selectAllClientAccountB");
        } finally {
            session.close();
        }
        return list;
    }
}
