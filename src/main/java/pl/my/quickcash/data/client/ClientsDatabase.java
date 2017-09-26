package pl.my.quickcash.data.client;



import pl.my.quickcash.datamanagement.FileManager;

import java.io.IOException;
import java.util.HashMap;

public class ClientsDatabase {
    private static HashMap<ClientKey, ClientData> clientsDatabase;

    static  {
        try {
            clientsDatabase =  FileManager.readDatabaseFromFile();
            System.out.println("Data loaded to file!");
        } catch (IOException e) {
            clientsDatabase = new HashMap<ClientKey, ClientData>();
            System.out.println("New database was created!");
        }
    }

    public static HashMap<ClientKey, ClientData> getInstance() {

        return clientsDatabase;
    }

}

