package util;

import data.Clientdata.ClientUtility;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by Nifury on 2014/10/25.
 */
public class RMIUtility {

    public static void init() throws RemoteException {
        Registry registry = LocateRegistry.createRegistry(1099);
        registry.rebind("Client", new ClientUtility());
    }

}
