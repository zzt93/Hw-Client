package businesslogicservice.Clientblservice;

import po.ClientPO;
import po.ClientFilter;

import java.util.Vector;

/**
 * Created by Nifury on 2014/10/20.
 */
public interface ClientUtilityImpl {

    void addClient(ClientPO clientPO) throws Exception;

    void deleteClient(String id) throws Exception;

    void modifyClient(ClientPO newClientPO) throws Exception;

    Vector<ClientPO> queryClient(Vector<ClientFilter> filters) throws Exception;

    ClientPO queryClientById(String id) throws Exception;

}
