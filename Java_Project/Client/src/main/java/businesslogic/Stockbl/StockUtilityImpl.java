package businesslogic.Stockbl;

import businesslogicservice.Stockblservice.StockUtility;
import dataservice.Stockdataservice.StockDataService;
import po.ResultMessage;
import po.StockReceiptPO;
import util.RMIUtility;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Vector;

/**
 * Created by Nifury on 2014/10/25.
 */
public class StockUtilityImpl implements StockUtility {

    private static StockDataService impl;

    static {
        try {
            impl = (StockDataService) RMIUtility.getImpl("Stock");
        } catch (RemoteException | NotBoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void makeReceipt(StockReceiptPO receiptPO) throws Exception {
        ResultMessage result = impl.makeReceipt(receiptPO);
        result.throwIfFailed();
    }

    @Override
    public Vector<StockReceiptPO> queryReceipt(Vector<String> filters) throws Exception {
        ResultMessage<Vector<StockReceiptPO>> result = impl.queryReceipt(filters);
        result.throwIfFailed();
        return result.getObj();
    }
}
