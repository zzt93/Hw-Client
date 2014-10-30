package businesslogic.Clientbl;

import dataservice.Clientdataservice.ClientDataService;
import po.ClientPO;

import java.rmi.RemoteException;

/**
 * Created by Nifury on 2014/10/25.
 */
public class ClientDataService_Driver {

    public void drive(ClientDataService impl) {
        ClientPO clientPO=new ClientPO(null,null,null,null,null,null,null,null);
        try {
            impl.addClient(clientPO);
            impl.deleteClient(0);
            impl.modifyClient(clientPO);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ClientDataService impl = new ClientDataService_Stub();
        ClientDataService_Driver driver = new ClientDataService_Driver();
        driver.drive(impl);
    }
}
