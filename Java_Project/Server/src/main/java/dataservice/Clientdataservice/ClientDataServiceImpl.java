package dataservice.Clientdataservice;

import po.Client;
import po.ClientFilter;
import po.ResultMessage;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Vector;

/**
 * Created by Nifury on 2014/10/25.
 */
public interface ClientDataServiceImpl extends Remote {
    public void addClient(Client client) throws RemoteException;
    public ResultMessage deleteClient(String id) throws RemoteException;
    public ResultMessage modifyClient(Client newClient) throws RemoteException;
    public Client queryClientById(String id) throws RemoteException;
    public Vector<Client> queryClient(Vector<ClientFilter> filters) throws RemoteException;

}
