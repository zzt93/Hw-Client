package businesslogic.RunningTablebl;

import java.util.Vector;

import po.ResultMessage;
import vo.GoodsRecordVO;
import vo.SaleConditionVO;
import businesslogic.Salebl.SaleUtilityImpl;

public class MockSaleUtilityImpl extends SaleUtilityImpl{
	public MockSaleUtilityImpl(){
		super("测试时使用");
	}
	public Vector<GoodsRecordVO> querySaleRecord(SaleConditionVO filter) throws Exception {
        //TODO get filter
		System.out.println("进入了Mock");
        Vector<GoodsRecordVO> record=new Vector<GoodsRecordVO>();
        record.add(new GoodsRecordVO());
        return record;

    }
}
