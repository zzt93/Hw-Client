package businesslogic.Clientbl;

import dataservice.Clientdataservice.ClientDataServiceImpl;
import po.ClientFilter;
import po.ClientPO;
import po.ResultMessage;

import java.rmi.RemoteException;
import java.util.Vector;

/**
 * Created by Nifury on 2014/10/25.
 */
public class ClientDataService_Stub implements ClientDataServiceImpl {
    @Override
    public ResultMessage addClient(ClientPO clientPO) throws RemoteException {
        return ResultMessage.noErr;
    }

    @Override
    public ResultMessage deleteClient(String id) throws RemoteException {
        return ResultMessage.noErr;
    }

    @Override
    public ResultMessage modifyClient(ClientPO newClientPO) throws RemoteException {
        return ResultMessage.noErr;
    }

    @Override
    public ResultMessage<ClientPO> queryClientById(String id) throws RemoteException {
        return new ResultMessage<>(null, new ClientPO(null, null, null, null, null, null, null, null));
    }

    @Override
    public ResultMessage<Vector<ClientPO>> queryClient(Vector<ClientFilter> filters) throws RemoteException {
        return null;
    }
}
