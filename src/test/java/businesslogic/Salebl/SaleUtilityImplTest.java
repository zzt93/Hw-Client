package businesslogic.Salebl;

import businesslogicservice.Saleblservice.SaleUtility;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import po.SaleReceiptPO;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import static org.junit.Assert.*;

public class SaleUtilityImplTest {

    private SaleUtility impl;

    @BeforeClass
    public void testBeforeClass() {
        try {
            impl = new SaleUtilityImpl();
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testMakeReceipt() throws Exception {
        SaleReceiptPO po = new SaleReceiptPO("id", 1, null, null, null, null, null, null);
        impl.makeReceipt(po);
    }

    @Ignore
    public void testQueryReceipt() throws Exception {

    }

    @Ignore
    public void testQuerySaleRecord() throws Exception {

    }
}