package pl.my.quickcash.data.converter;

import pl.my.quickcash.controllers.modelfx.ClientTransactionFx;
import pl.my.quickcash.data.client.ClientTransaction;

public class ClientTransactionConverter {

    public static ClientTransaction convertToClientTransaction(ClientTransactionFx clientTransactionFx) {
        ClientTransaction clientTransaction = new ClientTransaction(
                clientTransactionFx.getAmount(),
                clientTransactionFx.getClientAccountNumber(),
                clientTransactionFx.getSecondPartyAccountNumber(),
                clientTransactionFx.getTransactionType(),
                clientTransactionFx.getTransactionDate(),
                clientTransactionFx.getTransactionTime(),
                clientTransactionFx.getClientKeyId(),
                clientTransactionFx.getSecondPartyKeyId(),
                clientTransactionFx.getSecondPartyFirstName(),
                clientTransactionFx.getSecondPartyLastName());
        return clientTransaction;
    }

    public static ClientTransactionFx convertToClientTransactionFx(ClientTransaction clientTransaction) {
        ClientTransactionFx clientTransactionFx = new ClientTransactionFx();
        clientTransactionFx.setAmount(clientTransaction.getAmount());
        clientTransactionFx.setClientAccountNumber(clientTransaction.getClientAccountNumber());
        clientTransactionFx.setSecondPartyAccountNumber(clientTransaction.getSecondPartyAccountNumber());
        clientTransactionFx.setTransactionType(clientTransaction.getTransactionType());
        clientTransactionFx.setTransactionDate(clientTransaction.getTransactionDate());
        clientTransactionFx.setTransactionTime(clientTransaction.getTransactionTime());
        clientTransactionFx.setClientKeyId(clientTransaction.getClientKeyId());
        clientTransactionFx.setClientKeyId(clientTransaction.getSecondPartyKeyId());
        clientTransactionFx.setSecondPartyFirstName(clientTransaction.getSecondPartyFirstName());
        clientTransactionFx.setSecondPartyLastName(clientTransaction.getSecondPartyLastName());
        return clientTransactionFx;
    }
 }
