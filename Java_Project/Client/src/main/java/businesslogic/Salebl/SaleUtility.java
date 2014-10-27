package businesslogic.Salebl;

import businesslogicservice.Saleblservice.SaleUtilityImpl;
import dataservice.Saledataservice.SaleDataServiceImpl;
import po.ResultMessage;
import po.SaleReceiptPO;
import util.RMIUtility;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Vector;

/**
 * Created by Nifury on 2014/10/25.
 */
public class SaleUtility implements SaleUtilityImpl {

    private static SaleDataServiceImpl impl;

    static {
        try {
            impl = (SaleDataServiceImpl) RMIUtility.getImpl("Sale");
        } catch (RemoteException | NotBoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void makeReceipt(SaleReceiptPO receipt) throws Exception {
        ResultMessage result = impl.makeReceipt(receipt);
        result.throwIfFailed();
    }

    @Override
    public Vector<SaleReceiptPO> queryReceipt(Vector<String> filters) throws Exception {
        ResultMessage<Vector<SaleReceiptPO>> result = impl.queryReceipt(filters);
        result.throwIfFailed();
        return result.getObj();
    }


}
