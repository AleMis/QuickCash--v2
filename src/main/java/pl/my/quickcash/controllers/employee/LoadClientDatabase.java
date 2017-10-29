package pl.my.quickcash.controllers.employee;

import pl.my.quickcash.data.client.Client;
import pl.my.quickcash.data.client.ClientsList;

import java.util.List;

public class LoadClientDatabase {

    private static List<Client> loadClientDatabaseInstance = null;

    public LoadClientDatabase() {
    }

    public static List<Client> getInstance() {
        if (loadClientDatabaseInstance == null) {
            loadClientDatabaseInstance = ClientsList.createList();
        }
        return loadClientDatabaseInstance;
    }
}



