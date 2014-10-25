package util;

import data.Clientdata.ClientUtility;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by Nifury on 2014/10/25.
 */
public class RMIUtility {

    public static void init() {
        try {
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind("Client", new ClientUtility());
        } catch (RemoteException e) {
            throw new ContingencyException(e.getMessage(), e);
        }
    }

}
