package businesslogic.Salebl;

import dataservice.Saledataservice.SaleDataServiceImpl;

import java.rmi.RemoteException;

/**
 * Created by Nifury on 2014/10/25.
 */
public class SaleDataService_Driver {

    private void drive(SaleDataServiceImpl impl) {
        try {
            impl.makeReceipt(null);
            impl.queryReceipt(null);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SaleDataServiceImpl impl=new SaleDataService_Stub();
        SaleDataService_Driver driver = new SaleDataService_Driver();
        driver.drive(impl);
    }
}
