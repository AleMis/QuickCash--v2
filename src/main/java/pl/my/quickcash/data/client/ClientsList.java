package pl.my.quickcash.data.client;



import pl.my.quickcash.dao.CommunicationDAO;

import java.util.ArrayList;
import java.util.List;

public class ClientsList {

    private static final String SELECT_ALL_CLIENT_KEYS = "ClientKey.selectAllClientKey";
    private static final String SELECT_ALL_CLIENT_ACCOUNT_B = "ClientAccount.selectAllClientAccountB";
    private static final String SELECT_ALL_CLIENT_CONTACT_DETAILS = "ClientContactDetails.selectAllClientContactDetails";
    private static final String SELECT_ALL_CLIENT_PERSONAL_DATA = "ClientPersonalData.selectAllClientPersonalData";

    private static List<Client> list = new ArrayList<>();

    public static List<Client> createList() {
        List<ClientKey> clientKeyList = CommunicationDAO.selectList(SELECT_ALL_CLIENT_KEYS);

        for(int i = 0; i<clientKeyList.size(); i++) {
            ClientKey clientKey = clientKeyList.get(i);
            ClientData clientData = createClientDataLsit().get(i);
            Client client = new Client(clientKey,clientData);
            list.add(client);
        }
        return list;
    }

    private static List<ClientData> createClientDataLsit() {
        List<ClientPersonalData> clientPersonalDataList =  CommunicationDAO.selectList(SELECT_ALL_CLIENT_PERSONAL_DATA);
        List<ClientContactDetails> clientContactDetailsList = CommunicationDAO.selectList(SELECT_ALL_CLIENT_CONTACT_DETAILS);
        List<ClientAccount> clientAccountList = CommunicationDAO.selectList(SELECT_ALL_CLIENT_ACCOUNT_B);

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
