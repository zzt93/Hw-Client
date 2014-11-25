package businesslogic.Stockbl;

import businesslogicservice.Stockblservice.StockUtility;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import po.StockReceiptPO;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import static org.junit.Assert.*;

public class StockUtilityImplTest {

    private static StockUtility impl;

    @BeforeClass
    public static void testBeforeClass() {
        try {
            impl = new StockUtilityImpl();
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testMakeReceipt() throws Exception {
        StockReceiptPO po = new StockReceiptPO("id", null, null, null, null);
        impl.makeReceipt(po);
    }

    @Ignore
    public void testQueryReceipt() throws Exception {

    }
}