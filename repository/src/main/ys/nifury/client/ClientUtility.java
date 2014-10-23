package nifury.client;

import nifury.ContingencyException;

import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

import static nifury.client.ClientDataUtility.*;

/**
 * Created by Nifury on 2014/10/17.
 */
public class ClientUtility implements ClientUtilityImpl, Observer {


    @Override
    public void addClient(Client client) {
        addClientData(client.clone());
    }

    /**
     * @param id 客户编号
     * @throws nifury.ContingencyException 客户编号不存在
     */
    @Override
    public void deleteClient(String id) {
        Client client = queryClientDataById(id);
        if (client == null)
            throw new ContingencyException("客户编号不存在！");
        deleteClientData(client);
    }

    @Override
    public void modifyClient(Client newClient) {
        Client orignClient = queryClientDataById(newClient.getId());
        if (orignClient == null)
            throw new ContingencyException("客户编号不存在！");
        modifyClientData(orignClient, newClient);
    }

    /**
     * @param id 客户编号
     * @return 找不到此编号时返回null，否则返回对应客户
     */
    public Client queryClientById(String id) {
        Client client = queryClientDataById(id);
        if (client == null)
            return null;
        else
            return client.clone();
    }

    /**
     * @param filters 客户信息过滤数组，可为null
     * @return 当没有满足条件时，返回null，否则返回符合条件的客户Vector
     * @throws nifury.ContingencyException 理应不会抛出这个异常
     */
    @Override
    public Vector<Client> queryClient(ClientFilter[] filters) {
        Vector<Client> clients = queryClientData(filters);
        if (clients == null)
            return null;
        int length = clients.size();
        for (int i = 0; i < length; ++i) {
            clients.set(i, clients.get(i).clone());
        }
        return clients;
    }

    @Override
    public void update(Observable o, Object arg) {
        //TODO update
    }
}
