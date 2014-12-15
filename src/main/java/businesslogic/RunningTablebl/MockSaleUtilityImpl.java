package businesslogic.RunningTablebl;

import businesslogic.Salebl.SaleUtilityImpl;
import vo.GoodsRecordVO;
import vo.SaleConditionVO;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class MockSaleUtilityImpl extends SaleUtilityImpl{

	public MockSaleUtilityImpl() throws RemoteException, NotBoundException {
		super();
	}

	public List<GoodsRecordVO> querySaleRecord(SaleConditionVO filter) throws Exception {
        //TODO get filter
		System.out.println("进入了Mock");
        List<GoodsRecordVO> record=new ArrayList<GoodsRecordVO>();
        record.add(new GoodsRecordVO());
        return record;

    }
}
