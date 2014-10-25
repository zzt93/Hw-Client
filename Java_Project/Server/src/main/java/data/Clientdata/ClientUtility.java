package data.Clientdata;

import dataservice.Clientdataservice.ClientDataServiceImpl;
import po.Client;
import po.ClientFilter;
import po.ResultMessage;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

/**
 * Created by Nifury on 2014/10/25.
 */
public class ClientUtility extends UnicastRemoteObject implements ClientDataServiceImpl, Observer {

    public ClientUtility() throws RemoteException {
        super();
    }

    @Override
    public void addClient(Client client) throws RemoteException {

    }

    @Override
    public ResultMessage deleteClient(String id) throws RemoteException {
        return ResultMessage.noErr;
    }

    @Override
    public ResultMessage modifyClient(Client newClient) throws RemoteException {
        return ResultMessage.noErr;
    }

    @Override
    public Client queryClientById(String id) throws RemoteException {
        return null;
    }

    @Override
    public Vector<Client> queryClient(Vector<ClientFilter> filters) throws RemoteException {
        return null;
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
