package businesslogic.RunningTablebl;

import businesslogic.Salebl.SaleUtilityImpl;
import vo.GoodsRecordVO;
import vo.SaleConditionVO;

import java.util.Vector;

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
