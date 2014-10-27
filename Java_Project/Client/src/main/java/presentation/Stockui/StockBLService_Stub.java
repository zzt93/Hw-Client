package presentation.Stockui;

import businesslogicservice.Stockblservice.StockUtilityImpl;
import po.StockReceiptPO;

import java.util.Vector;

/**
 * Created by Nifury on 2014/10/25.
 */
public class StockBLService_Stub implements StockUtilityImpl {

    private static Vector<StockReceiptPO> data = new Vector<>();

    @Override
    public void makeReceipt(StockReceiptPO receiptPO) throws Exception {
        data.add(receiptPO);
    }

    @Override
    public Vector<StockReceiptPO> queryReceipt(Vector<String> filters) throws Exception {
        return data;
    }
}
