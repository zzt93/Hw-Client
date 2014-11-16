package businesslogic.Stockbl;

import dataservice.Stockdataservice.StockDataService;
import po.ResultMessage;
import po.StockReceiptPO;

import java.rmi.RemoteException;
import java.util.Vector;

/**
 * Created by Nifury on 2014/10/25.
 */
public class StockDataService_Stub implements StockDataService {
    @Override
    public ResultMessage makeReceipt(StockReceiptPO receiptPO) throws RemoteException {
        return new ResultMessage(null, null);
    }

    @Override
    public ResultMessage<Vector<StockReceiptPO>> queryReceipt(Vector<String> filters) throws RemoteException {
        return new ResultMessage(null, null);
    }
}
