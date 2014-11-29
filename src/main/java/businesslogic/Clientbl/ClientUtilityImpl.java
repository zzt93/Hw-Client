package businesslogic.Clientbl;

import businesslogicservice.Clientblservice.ClientUtility;
import dataservice.Clientdataservice.ClientDataService;
import po.ClientPO;
import po.ResultMessage;
import util.RMIUtility;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Nifury on 2014/10/20.
 */
public class ClientUtilityImpl implements ClientUtility {

    private static ClientDataService impl;

    public ClientUtilityImpl() throws RemoteException, NotBoundException {
        if (impl == null)
            impl = (ClientDataService) RMIUtility.getImpl("Client");
    }

    @Override
    public int addClient(ClientPO clientPO) throws Exception {
        ResultMessage<Integer> result = impl.addClient(clientPO);
        result.throwIfFailed();
        return result.getObj();
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
     * @param filters 客户信息过滤向量，可为null
     * @return 当没有满足条件时，返回空List，否则返回符合条件的客户Vector
     */
    @Override
    public List<ClientPO> queryClient(HashMap<String, Object> filters) throws Exception {
        ResultMessage<List<ClientPO>> result = impl.queryClient(filters);
        result.throwIfFailed();
        return result.getObj();
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

}
