package dataservice.Clientdataservice;

import po.ClientPO;
import po.ResultMessage;
import vo.Filter;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Vector;

/**
 * Created by Nifury on 2014/10/25.
 */
public interface ClientDataService extends Remote {
    public ResultMessage<Integer> addClient(ClientPO clientPO) throws RemoteException;
    public ResultMessage deleteClient(int id) throws RemoteException;
    public ResultMessage modifyClient(ClientPO newClientPO) throws RemoteException;
    public ResultMessage<ClientPO> queryClientById(int id) throws RemoteException;
    public ResultMessage<Vector<ClientPO>> queryClient(Vector<Filter> filters) throws RemoteException;
}
