package pl.my.quickcash.data.client;



import pl.my.quickcash.dao.MyBatisConnectionFactory;
import pl.my.quickcash.dao.clients.ClientAccountDAO;
import pl.my.quickcash.dao.clients.ClientContactDetailsDAO;
import pl.my.quickcash.dao.clients.ClientKeyDAO;
import pl.my.quickcash.dao.clients.ClientPersonalDataDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ClientsList {

    private static List<Client> list = new ArrayList<>();

    public static List<Client> createList() {
        ClientKeyDAO clientKeyDAO = new ClientKeyDAO(MyBatisConnectionFactory.getSqlSessionFactory());
        List<ClientKey> clientKeyList = clientKeyDAO.selectAllClientKey();

        for(int i = 0; i<clientKeyList.size(); i++) {
            ClientKey clientKey = clientKeyList.get(i);
            ClientData clientData = createClientDataLsit().get(i);
            Client client = new Client(clientKey,clientData);
            list.add(client);
        }
        return list;
    }

    private static List<ClientData> createClientDataLsit() {
        ClientPersonalDataDAO clientPersonalDataDAO = new ClientPersonalDataDAO(MyBatisConnectionFactory.getSqlSessionFactory());
        ClientContactDetailsDAO clientContactDetailsDAO = new ClientContactDetailsDAO(MyBatisConnectionFactory.getSqlSessionFactory());
        ClientAccountDAO clientAccountDAO = new ClientAccountDAO(MyBatisConnectionFactory.getSqlSessionFactory());

        List<ClientPersonalData> clientPersonalDataList = clientPersonalDataDAO.selectAllClientPersonalData();
        List<ClientContactDetails> clientContactDetailsList = clientContactDetailsDAO.selectAllClientContactDetails();
        List<ClientAccount> clientAccountList = clientAccountDAO.selectAllClientAccountB();

        List<ClientData> clientDataList = new ArrayList<>();

        for(int i = 0; i<clientPersonalDataList.size(); i++) {
            ClientPersonalData clientPersonalData = clientPersonalDataList.get(i);
            ClientContactDetails clientContactDetails = clientContactDetailsList.get(i);
            ClientAccount clientAccount = clientAccountList.get(i);
            ClientData clientData = new ClientData(clientPersonalData, clientContactDetails, clientAccount);
            clientDataList.add(clientData);
        }
        return clientDataList;
    }
}
