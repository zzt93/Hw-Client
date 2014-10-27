package presentation.Clientui;

import businesslogicservice.Clientblservice.ClientUtilityImpl;
import po.ClientPO;

import java.util.Vector;

/**
 * Created by Nifury on 2014/10/25.
 */
public class ClientBLService_Stub implements ClientUtilityImpl {
    private static Vector<ClientPO> data = new Vector<>();
    @Override
    public void addClient(ClientPO clientPO) throws Exception {
        data.add(clientPO);
    }

    @Override
    public void deleteClient(int id) throws Exception {
        data.remove(queryClientById(id));
    }

    @Override
    public void modifyClient(ClientPO newClientPO) throws Exception {
        int idx = data.indexOf(queryClientById(newClientPO.getId()));
        if (idx == -1)
            throw new Exception("未找到客户");
        data.set(idx, newClientPO);
    }

    @Override
    public Vector<ClientPO> queryClient(Vector<String> filters) throws Exception {
        return data;
    }

    @Override
    public ClientPO queryClientById(int id) throws Exception {
        for (ClientPO clientPO : data) {
            if (id == clientPO.getId())
                return clientPO;
        }
        return null;
    }
}
