package businesslogic.Salebl;

import dataservice.Saledataservice.SaleDataService;
import po.ResultMessage;
import po.SaleReceiptPO;

import java.rmi.RemoteException;
import java.util.Vector;

/**
 * Created by Nifury on 2014/10/25.
 */
public class SaleDataService_Stub implements SaleDataService {
    @Override
    public ResultMessage makeReceipt(SaleReceiptPO receiptPO) throws RemoteException {
        return ResultMessage.noErr;
    }

    @Override
    public ResultMessage<Vector<SaleReceiptPO>> queryReceipt(Vector<String> filters) throws RemoteException {
        return ResultMessage.noErr;
    }
}
