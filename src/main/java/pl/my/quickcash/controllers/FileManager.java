package pl.my.quickcash.controllers;

import pl.my.quickcash.data.*;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class FileManager {

    private static final String fileName = "UsersDatabase";

//    public void writeDatabaseToFile() {
//
//        File file = new File(fileName);
//        boolean fileExists = file.exists();
//
//        if(!fileExists) {
//            try {
//                fileExists = file.createNewFile();
//            } catch(IOException o) {
//                System.out.println("Program could not create the file!");
//            }
//        }
//        if(fileExists) {
//            try(
//                    FileWriter fileWriter = new FileWriter(fileName);
//                    BufferedWriter writer = new BufferedWriter(fileWriter);
//            ) {
//
//                for(Map.Entry<ClientKey, ClientData> entry : clientsDatabase.entrySet())  {
//                    writer.write(entry.getKey() + "" + entry.getValue());
//                    writer.newLine();
//                }
//            } catch (FileNotFoundException e) {
//                System.out.println("Program could not find the file: " + fileName);
//            }catch (IOException e) {
//                System.out.println("Error during saving the data " + fileName);
//
//            }
//        }
//    }

    public static HashMap<ClientKey, ClientData> readDatabaseFromFile() throws IOException {
        HashMap<ClientKey, ClientData> database = new HashMap<ClientKey, ClientData>();

        try(
                FileReader fileReader = new FileReader(fileName);
                BufferedReader reader = new BufferedReader(fileReader);
        ) {
            String nextLine = null;
            int lines = 0;
            while((nextLine = reader.readLine()) != null) {
                String[] parts = nextLine.split("; ");

                String login = parts[0];
                String password = parts[1];
                ClientKey clientKey = new ClientKey(login,password);

                String firstName = parts[2];
                String lastName = parts[3];
                String pesel = parts[4];
                String idCard = parts[5];
                String country = parts[6];
                String voivodeship = parts[7];
                String city = parts[8];
                String street = parts[9];
                String buildingNumber = parts[10];
                String flatNumber = parts[11];

                ClientPersonalData userPD = new ClientPersonalData( firstName,
                        lastName,
                        pesel,
                        idCard,
                        country,
                        voivodeship,
                        city,
                        street,
                        buildingNumber,
                        flatNumber);
                String countryCD = parts[12];
                String voivodeshipCD = parts[13];
                String cityCD = parts[14];
                String streetCD = parts[15];
                String buildingNumberCD = parts[16];
                String flatNumberCD = parts[17];

                ClientContactDetails userCD = new ClientContactDetails( countryCD,
                        voivodeshipCD,
                        cityCD,
                        streetCD,
                        buildingNumberCD,
                        flatNumberCD);

                Double accountBalanceAsDouble = Double.parseDouble(parts[18]);
                Long accountNumber = Long.parseLong(parts[19]);
                ClientAccount clientAccount = new ClientAccount(accountBalanceAsDouble, accountNumber);

                ClientData clientData = new ClientData(userPD, userCD, clientAccount);

                database.put(clientKey, clientData);
                lines++;

            }
            reader.close();

        }catch (FileNotFoundException e) {
            System.err.println("Program could not find the file: " + fileName);
            throw e;
        } catch (IOException e) {
            System.err.println("Error during saving the data " + fileName);
            throw e;
        }
        return database;
    }
}

