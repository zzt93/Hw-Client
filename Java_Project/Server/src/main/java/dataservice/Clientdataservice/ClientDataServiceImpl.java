package dataservice.Clientdataservice;

import po.Client;
import po.ClientFilter;
import po.ResultMessage;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Observer;
import java.util.Vector;

/**
 * Created by Nifury on 2014/10/25.
 */
public interface ClientDataServiceImpl extends Remote {
    public ResultMessage addClient(Client clientPO) throws RemoteException;
    public ResultMessage deleteClient(String id) throws RemoteException;
    public ResultMessage modifyClient(Client newClientPO) throws RemoteException;
    public ResultMessage<Client> queryClientById(String id) throws RemoteException;
    public ResultMessage<Vector<Client>> queryClient(Vector<ClientFilter> filters) throws RemoteException;

}
