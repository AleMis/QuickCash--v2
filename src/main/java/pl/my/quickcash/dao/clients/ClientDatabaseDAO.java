package pl.my.quickcash.dao.clients;

import pl.my.quickcash.dao.MyBatisConnectionFactory;
import pl.my.quickcash.data.client.ClientData;
import pl.my.quickcash.data.client.ClientKey;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class ClientDatabaseDAO {

    private static HashMap<ClientKey, ClientData> clientsDatabase = null;

    private static ClientKeyDAO clientKeyDAO = new ClientKeyDAO(MyBatisConnectionFactory.getSqlSessionFactory());
//
//    static  {
//        List<ClientKey> keys = clientKeyDAO.selectClientKey();
//        List<ClientData> data = ClientDataDAO.getClientDataDAO();
//
//        System.out.println(keys);
//        System.out.println(data);
//
//        if (keys.size() != data.size())
//            throw new IllegalArgumentException ("Cannot combine lists with dissimilar sizes");
//        clientsDatabase = new LinkedHashMap<>();
//        for (int i=0; i<keys.size(); i++) {
//            clientsDatabase.put(keys.get(i), data.get(i));
//        }
//    }

    public static HashMap<ClientKey, ClientData> getInstance() {
        return clientsDatabase;
    }

}
