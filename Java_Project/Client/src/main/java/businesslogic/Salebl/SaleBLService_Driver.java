package businesslogic.Salebl;

import businesslogicservice.Saleblservice.SaleUtilityImpl;
import po.SaleReceiptPO;

/**
 * Created by Nifury on 2014/10/25.
 */
public class SaleBLService_Driver {

    private static SaleReceiptPO receiptPO = new SaleReceiptPO("id", null, null, null, null,
            null, null, null);

    public void drive(SaleUtilityImpl impl) {
        try {
            impl.makeReceipt(receiptPO);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SaleUtilityImpl impl = new SaleBLService_Stub();
        SaleBLService_Driver driver = new SaleBLService_Driver();
        driver.drive(impl);
    }
}
