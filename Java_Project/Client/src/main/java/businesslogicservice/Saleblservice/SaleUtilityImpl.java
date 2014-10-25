package businesslogicservice.Saleblservice;

import po.ReceiptFilter;
import po.SaleReceiptPO;

import java.util.Vector;

/**
 * Created by Nifury on 2014/10/25.
 */
public interface SaleUtilityImpl {
    public void makeReceipt(SaleReceiptPO receipt) throws Exception;
    public Vector<SaleReceiptPO> queryReceipt(Vector<ReceiptFilter> filters) throws Exception;
}
