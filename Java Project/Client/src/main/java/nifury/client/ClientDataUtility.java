package nifury.client;

import nifury.ContingencyException;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Vector;

/**
 * Created by Nifury on 2014/10/20.
 */
public class ClientDataUtility {

    private static Vector<Client> clientData = new Vector<Client>();

    static void addClientData(Client client) {
        clientData.add(client);
    }

    static void deleteClientData(Client client) {
        clientData.remove(client);
    }

    static void modifyClientData(Client orignClient, Client newClient) {
        Field[] fields = Client.class.getDeclaredFields();
        try {
            for (Field field : fields) {
                if (field.getType() != BigDecimal.class) {
                    //TODO 怪怪的……
                    field.setAccessible(true);
                    field.set(orignClient, field.get(newClient));
                }
            }
        } catch (IllegalAccessException e) {
            throw new ContingencyException(e.getMessage(), e);
        }
    }

    static Client queryClientDataById(String id) {
        Vector<Client> client = queryClientData(new ClientFilter[]{
                new ClientFilter("id", id),
        });
        if (client == null)
            return null;
        else
            return client.get(0);
    }

    static Vector<Client> queryClientData(ClientFilter[] filters) {
        if (filters == null)
            return (Vector<Client>) clientData.clone();
        Field[] fields = new Field[filters.length];
        Class clientClass = Client.class;
        try {
            for (int i = 0; i < fields.length; ++i) {
                fields[i] = clientClass.getDeclaredField(filters[i].getKey());
                fields[i].setAccessible(true);
            }
        } catch (NoSuchFieldException e) {
            throw new ContingencyException(e.getMessage(), e);
        }

        Object[] values = new Object[fields.length];
        for (int i = 0; i < fields.length; ++i) {
            values[i] = filters[i].getValue();
        }

        Vector<Client> result = new Vector<Client>();
        try {
            for (Client client : clientData) {
                boolean bMatch = true;
                for (int i = 0; i < fields.length; ++i) {
                    if (!fields[i].get(client).equals(values[i])) {
                        bMatch = false;
                        break;
                    }
                }
                if (bMatch) {
                    result.add(client);
                }
            }
        } catch (IllegalAccessException e) {
            throw new ContingencyException(e.getMessage(), e);
        }
        if (result.isEmpty())
            return null;
        else
            return result;
    }

}
