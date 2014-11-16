package dataservice.Saledataservice;

import po.ResultMessage;
import po.SaleReceiptPO;
import vo.GoodsRecordVO;
import vo.ReceiptConditionVO;
import vo.SaleConditionVO;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Vector;

/**
 * Created by Nifury on 2014/10/25.
 */
public interface SaleDataService extends Remote {
    public ResultMessage makeReceipt(SaleReceiptPO receiptPO) throws RemoteException;

    public ResultMessage<Vector<SaleReceiptPO>> queryReceipt(ReceiptConditionVO filter)
            throws RemoteException;

    public ResultMessage<Vector<GoodsRecordVO>> querySaleRecord(SaleConditionVO filter) throws RemoteException;
}
