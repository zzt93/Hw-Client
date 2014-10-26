import util.MySQLUtility;
import util.RMIUtility;

import java.rmi.RemoteException;
import java.sql.SQLException;

/**
 * Created by Nifury on 2014/10/26.
 */
public class main {
    public static void main(String[] args) {
        try {
            MySQLUtility.init();
            RMIUtility.init();
        } catch (ClassNotFoundException | SQLException | RemoteException e) {
            e.printStackTrace();
        }
    }
}
