package businesslogic.Stockbl;

import dataservice.Stockdataservice.StockDataService;

import java.rmi.RemoteException;

/**
 * Created by Nifury on 2014/10/25.
 */
public class StockDataService_Driver {

    public void drive(StockDataService impl) {
        try {
            impl.makeReceipt(null);
            impl.queryReceipt(null);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        StockDataService impl=new StockDataService_Stub();
        StockDataService_Driver driver = new StockDataService_Driver();
        driver.drive(impl);
    }
}
