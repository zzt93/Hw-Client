package businesslogicservice.Saleblservice;

import po.SaleReceiptPO;

import java.util.Vector;

/**
 * Created by Nifury on 2014/10/25.
 */
public interface SaleUtility {
    public void makeReceipt(SaleReceiptPO receipt) throws Exception;
    public Vector<SaleReceiptPO> queryReceipt(Vector<String> filters) throws Exception;
}
