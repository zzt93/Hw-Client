package dataservice.Stockdataservice;

import po.ReceiptFilter;
import po.ResultMessage;
import po.StockReceiptPO;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Vector;

/**
 * Created by Nifury on 2014/10/25.
 */
public interface StockDataServiceImpl extends Remote {
    public ResultMessage makeReceipt(StockReceiptPO receiptPO) throws RemoteException;
    public ResultMessage<Vector<StockReceiptPO>> queryReceipt(Vector<ReceiptFilter> filters)
            throws RemoteException;
}
