package businesslogicservice.Saleblservice;

import po.SaleReceiptPO;
import vo.GoodsRecordVO;
import vo.ReceiptConditionVO;
import vo.SaleConditionVO;

import java.util.Vector;

/**
 * Created by Nifury on 2014/10/25.
 */
public interface SaleUtility {
    public void makeReceipt(SaleReceiptPO receipt) throws Exception;
    public Vector<SaleReceiptPO> queryReceipt(ReceiptConditionVO filter) throws Exception;
    public Vector<GoodsRecordVO> querySaleRecord(SaleConditionVO filter) throws Exception;
}
