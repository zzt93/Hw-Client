package dataservice.Clientdataservice;

import po.ClientPO;
import po.ResultMessage;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Vector;

/**
 * Created by Nifury on 2014/10/25.
 */
public interface ClientDataServiceImpl extends Remote {
    public ResultMessage addClient(ClientPO clientPO) throws RemoteException;
    public ResultMessage deleteClient(String id) throws RemoteException;
    public ResultMessage modifyClient(ClientPO newClientPO) throws RemoteException;
    public ResultMessage<ClientPO> queryClientById(String id) throws RemoteException;
    public ResultMessage<Vector<ClientPO>> queryClient(Vector<String> filters) throws RemoteException;
}
