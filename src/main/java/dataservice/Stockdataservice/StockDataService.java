package dataservice.Stockdataservice;

import po.ResultMessage;
import po.StockReceiptPO;
import vo.ReceiptConditionVO;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by Nifury on 2014/10/25.
 */
public interface StockDataService extends Remote {
    public ResultMessage makeReceipt(StockReceiptPO receiptPO) throws RemoteException;

    public ResultMessage<List<StockReceiptPO>> queryReceipt(ReceiptConditionVO filter) throws RemoteException;
}
