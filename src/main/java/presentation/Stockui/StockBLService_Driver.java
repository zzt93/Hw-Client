package presentation.Stockui;

import businesslogicservice.Stockblservice.StockUtility;
import po.StockReceiptPO;

/**
 * Created by Nifury on 2014/10/25.
 */
public class StockBLService_Driver {

    private static StockReceiptPO receiptPO = new StockReceiptPO("id", null, null, null, null);

    public void drive(StockUtility impl) {
        try {
            impl.makeReceipt(receiptPO);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
