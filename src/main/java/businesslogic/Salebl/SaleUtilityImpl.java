package businesslogic.Salebl;

import businesslogicservice.Saleblservice.SaleUtility;
import dataservice.Saledataservice.SaleDataService;
import po.ResultMessage;
import po.SaleReceiptPO;
import util.RMIUtility;
import vo.GoodsRecordVO;
import vo.ReceiptConditionVO;
import vo.SaleConditionVO;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by Nifury on 2014/10/25.
 */
public class SaleUtilityImpl implements SaleUtility {

    private static SaleDataService impl;

    public SaleUtilityImpl() throws RemoteException, NotBoundException {
        if (impl == null)
            impl = (SaleDataService) RMIUtility.getImpl("Sale");
    }

    @Override
    public void makeReceipt(SaleReceiptPO receipt) throws Exception {
        ResultMessage result = impl.makeReceipt(receipt);
        result.throwIfFailed();
    }

    @Override
    public Vector<SaleReceiptPO> queryReceipt(ReceiptConditionVO filter) throws Exception {
        ResultMessage<Vector<SaleReceiptPO>> result = impl.queryReceipt(filter);
        result.throwIfFailed();
        return result.getObj();
    }

    @Override
    public Vector<GoodsRecordVO> querySaleRecord(SaleConditionVO filter) throws Exception {
        ResultMessage<Vector<GoodsRecordVO>> result = impl.querySaleRecord(filter);
        result.throwIfFailed();
        return result.getObj();
    }


}
