package pl.my.quickcash.dao.clients;

import com.sun.security.ntlm.Client;
import pl.my.quickcash.dao.MyBatisConnectionFactory;
import pl.my.quickcash.dao.employee.EmployeeDataDAO;
import pl.my.quickcash.dao.employee.EmployeeKeyDAO;
import pl.my.quickcash.data.client.*;
import pl.my.quickcash.data.employee.EmployeeData;
import pl.my.quickcash.data.employee.EmployeeKey;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class ClientDataDAO {

    private static ClientAccountDAO clientAccountDAO = new ClientAccountDAO(MyBatisConnectionFactory.getSqlSessionFactory());
    private static ClientPersonalDataDAO clientPersonalDataDAO = new ClientPersonalDataDAO(MyBatisConnectionFactory.getSqlSessionFactory());
    private static ClientContactDetailsDAO clientContactDetailsDAO = new ClientContactDetailsDAO(MyBatisConnectionFactory.getSqlSessionFactory());

//    public static List<ClientData> getClientDataDAO() {
//
//        List<ClientPersonalData> clientPersonalDataList = clientPersonalDataDAO.selectClientPersonalData();
//        List<ClientContactDetails> clientContactDetailsList = clientContactDetailsDAO.selectClientContactDetails();
//        List<ClientAccount> clientAccountList = clientAccountDAO.selectClientAccount();
//        List<ClientData> clientDataList = new ArrayList<>();
//
//        for (int i = 0; i<clientPersonalDataList.size(); i++) {
//            clientDataList.add(new ClientData(clientPersonalDataList.get(i), clientContactDetailsList.get(i), clientAccountList.get(i)));
//        }
//
//        return clientDataList;
//    }
}
