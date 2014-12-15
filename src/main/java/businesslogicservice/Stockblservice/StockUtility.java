package businesslogicservice.Stockblservice;

import po.StockReceiptPO;
import vo.ReceiptConditionVO;

import java.util.List;

/**
 * Created by Nifury on 2014/10/25.
 */
public interface StockUtility {
    public void makeReceipt(StockReceiptPO receiptPO) throws Exception;
    public List<StockReceiptPO> queryReceipt(ReceiptConditionVO filter) throws Exception;
}
