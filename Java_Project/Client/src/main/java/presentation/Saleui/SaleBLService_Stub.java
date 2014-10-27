package presentation.Saleui;

import businesslogicservice.Saleblservice.SaleUtilityImpl;
import po.SaleReceiptPO;

import java.util.Vector;

/**
 * Created by Nifury on 2014/10/25.
 */
public class SaleBLService_Stub implements SaleUtilityImpl {

    private static Vector<SaleReceiptPO> data = new Vector<>();

    @Override
    public void makeReceipt(SaleReceiptPO receipt) throws Exception {
        data.add(receipt);
    }

    @Override
    public Vector<SaleReceiptPO> queryReceipt(Vector<String> filters) throws Exception {
        return data;
    }
}
