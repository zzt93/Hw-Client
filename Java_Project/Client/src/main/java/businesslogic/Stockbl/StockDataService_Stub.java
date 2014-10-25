package businesslogic.Stockbl;

import dataservice.Stockdataservice.StockDataServiceImpl;
import po.ReceiptFilter;
import po.ResultMessage;
import po.StockReceiptPO;

import java.rmi.RemoteException;
import java.util.Vector;

/**
 * Created by Nifury on 2014/10/25.
 */
public class StockDataService_Stub implements StockDataServiceImpl {
    @Override
    public ResultMessage makeReceipt(StockReceiptPO receiptPO) throws RemoteException {
        return ResultMessage.noErr;
    }

    @Override
    public ResultMessage<Vector<StockReceiptPO>> queryReceipt(Vector<ReceiptFilter> filters) throws RemoteException {
        return ResultMessage.noErr;
    }
}
