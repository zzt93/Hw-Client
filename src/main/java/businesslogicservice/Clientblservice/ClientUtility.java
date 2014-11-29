package businesslogicservice.Clientblservice;

import po.ClientPO;
import vo.Filter;

import java.util.Vector;

/**
 * Created by Nifury on 2014/10/20.
 */
public interface ClientUtility {

    int addClient(ClientPO clientPO) throws Exception;

    void deleteClient(int id) throws Exception;

    void modifyClient(ClientPO newClientPO) throws Exception;

    Vector<ClientPO> queryClient(Vector<Filter> filters) throws Exception;

    ClientPO queryClientById(int id) throws Exception;

}
