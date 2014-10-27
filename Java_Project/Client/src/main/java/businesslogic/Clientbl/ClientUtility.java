package businesslogic.Clientbl;

import businesslogicservice.Clientblservice.ClientUtilityImpl;
import dataservice.Clientdataservice.ClientDataServiceImpl;
import po.ClientPO;
import po.ResultMessage;
import util.RMIUtility;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Vector;

/**
 * Created by Nifury on 2014/10/20.
 */
public class ClientUtility implements ClientUtilityImpl {

    private static ClientDataServiceImpl impl;

    public ClientUtility() throws RemoteException, NotBoundException {
        if (impl == null)
            impl = (ClientDataServiceImpl) RMIUtility.getImpl("Client");
    }

    @Override
    public void addClient(ClientPO clientPO) throws Exception {
        ResultMessage result = impl.addClient(clientPO);
        result.throwIfFailed();
    }

    @Override
    public void deleteClient(int id) throws Exception {
        ResultMessage result = impl.deleteClient(id);
        result.throwIfFailed();
    }

    @Override
    public void modifyClient(ClientPO newClientPO) throws Exception {
        ResultMessage result = impl.modifyClient(newClientPO);
        result.throwIfFailed();
    }

    /**
     * @param id 客户编号
     * @return 找不到此编号时抛出异常，否则返回对应客户
     */
    public ClientPO queryClientById(int id) throws Exception {
        ResultMessage<ClientPO> result = impl.queryClientById(id);
        result.throwIfFailed();
        return result.getObj();
    }

    /**
     * @param filters 客户信息过滤向量，可为null
     * @return 当没有满足条件时，返回空Vector，否则返回符合条件的客户Vector
     */
    @Override
    public Vector<ClientPO> queryClient(Vector<String> filters) throws Exception {
        ResultMessage<Vector<ClientPO>> result = impl.queryClient(filters);
        result.throwIfFailed();
        return result.getObj();
    }

}
