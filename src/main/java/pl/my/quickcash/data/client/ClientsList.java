package pl.my.quickcash.data.client;



import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ClientsList {

    private static List<Client> list = new ArrayList<>();

    public static List<Client> createList() {
        for(Map.Entry<ClientKey, ClientData> entry : ClientsDatabase.getInstance().entrySet()) {
            ClientKey clientKey = entry.getKey();
            ClientData clientData = entry.getValue();
            Client client = new Client(clientKey, clientData);
            list.add(client);
        }
        return list;
    }
}
