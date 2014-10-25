package businesslogicservice.Stockblservice;

import po.ReceiptFilter;
import po.StockReceiptPO;

import java.util.Vector;

/**
 * Created by Nifury on 2014/10/25.
 */
public interface StockUtilityImpl {
    public void makeReceipt(StockReceiptPO receiptPO) throws Exception;
    public Vector<StockReceiptPO> queryReceipt(Vector<ReceiptFilter> filters) throws Exception;
}
