package nifury.client;

import java.util.Vector;

/**
 * Created by Nifury on 2014/10/17.
 */
public interface ClientUtilityImpl {

    void addClient(Client client);
    void deleteClient(String id);
    void modifyClient(Client newClient);
    Vector<Client> queryClient(ClientFilter[] filters);
    Client queryClientById(String id);

}
