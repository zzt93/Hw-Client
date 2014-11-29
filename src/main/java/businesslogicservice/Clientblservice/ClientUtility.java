package businesslogicservice.Clientblservice;

import po.ClientPO;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Nifury on 2014/10/20.
 */
public interface ClientUtility {

    int addClient(ClientPO clientPO) throws Exception;

    void deleteClient(int id) throws Exception;

    void modifyClient(ClientPO newClientPO) throws Exception;

    List<ClientPO> queryClient(HashMap<String, Object> filters) throws Exception;

    ClientPO queryClientById(int id) throws Exception;

}
