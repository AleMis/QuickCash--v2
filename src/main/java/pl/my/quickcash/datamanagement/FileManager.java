package pl.my.quickcash.datamanagement;

import pl.my.quickcash.data.client.*;
import pl.my.quickcash.data.employee.EmployeeData;
import pl.my.quickcash.data.employee.EmployeeKey;


import java.io.*;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class FileManager {

    private static final String clientsFileName = "ClientsDatabase";
    private static final String employeesFileName = "Employeesdatabase";

    public void writeDatabaseToFile() {

        File file = new File(clientsFileName);
        boolean fileExists = file.exists();

        if(!fileExists) {
            try {
                fileExists = file.createNewFile();
            } catch(IOException o) {
                System.out.println("Program could not create the file!");
            }
        }
        if(fileExists) {
            try(
                    FileWriter fileWriter = new FileWriter(clientsFileName);
                    BufferedWriter writer = new BufferedWriter(fileWriter);
            ) {
                for(Map.Entry<ClientKey, ClientData> entry : ClientsDatabase.getInstance().entrySet())  {
                    writer.write(entry.getKey() + "" + entry.getValue());
                    writer.newLine();
                }
                writer.flush();

            }catch (FileNotFoundException e) {
                System.out.println("Program could not find the file: " + clientsFileName);
            }catch (IOException e) {
                System.out.println("Error during saving the data " + clientsFileName);

            }
        }
    }

    public static HashMap<ClientKey, ClientData> readDatabaseFromFile() throws IOException {
        HashMap<ClientKey, ClientData> database = new HashMap<ClientKey, ClientData>();

        try(
                FileReader fileReader = new FileReader(clientsFileName);
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
                        flatNumberCD, 1);

                BigDecimal accountBalanceAsDouble = new BigDecimal(parts[18]).setScale(2, BigDecimal.ROUND_CEILING);
                String accountNumber = parts[19];
                ClientAccount clientAccount = new ClientAccount(accountBalanceAsDouble, accountNumber);

                ClientData clientData = new ClientData(userPD, userCD, clientAccount);

                database.put(clientKey, clientData);
                lines++;

            }
            reader.close();

        }catch (FileNotFoundException e) {
            System.err.println("Program could not find the file: " + clientsFileName);
            throw e;
        } catch (IOException e) {
            System.err.println("Error during saving the data " + clientsFileName);
            throw e;
        }
        return database;
    }

    public static HashMap<EmployeeKey, EmployeeData> readEmployeesDatabaseFromFile() throws IOException {
        HashMap<EmployeeKey, EmployeeData> database = new HashMap<>();

        try(
                FileReader fileReader = new FileReader(employeesFileName);
                BufferedReader reader = new BufferedReader(fileReader);
        ) {
            String nextLine = null;
            int lines = 0;
            while((nextLine = reader.readLine()) != null) {
                String[] parts = nextLine.split("; ");

                String login = parts[0];
                String password = parts[1];
                EmployeeKey employeeKey = new EmployeeKey(1,login,password);

                String firstName = parts[2];
                String lastName = parts[3];
                String position = parts[4];

                EmployeeData employeeData = new EmployeeData(firstName, lastName, position);

                database.put(employeeKey, employeeData);
                lines++;
            }
            reader.close();

        }catch (FileNotFoundException e) {
            System.err.println("Program could not find the  file: " + employeesFileName);
            throw e;
        } catch (IOException e) {
            System.err.println("Error during saving the data " + employeesFileName);
            throw e;
        }
        return database;
    }
}

