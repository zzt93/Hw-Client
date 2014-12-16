package businesslogic.Stockbl;

import businesslogicservice.Stockblservice.StockUtility;
import dataservice.Stockdataservice.StockDataService;
import po.ResultMessage;
import po.StockReceiptPO;
import util.RMIUtility;
import vo.ReceiptConditionVO;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by Nifury on 2014/10/25.
 */
public class StockUtilityImpl implements StockUtility {

    private static StockDataService impl;

    public StockUtilityImpl() throws RemoteException, NotBoundException {
        if (impl == null)
            impl = (StockDataService) RMIUtility.getImpl("Stock");
    }

    @Override
    public void makeReceipt(StockReceiptPO receiptPO) throws Exception {
        ResultMessage result = impl.makeReceipt(receiptPO);
        result.throwIfFailed();
    }

    @Override
    public List<StockReceiptPO> queryReceipt(ReceiptConditionVO filter) throws Exception {
        //TODO get filter
        ResultMessage<List<StockReceiptPO>> result = impl.queryReceipt(filter);
        result.throwIfFailed();
        return result.getObj();
    }
}
