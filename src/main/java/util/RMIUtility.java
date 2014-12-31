package util;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by Nifury on 2014/10/25.
 */
public class RMIUtility {

    private static Registry registry;

    static {
        try {
            registry = LocateRegistry.getRegistry("172.26.212.9");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public static Remote getImpl(String name) throws RemoteException, NotBoundException {
        return registry.lookup(name);
    }

}
