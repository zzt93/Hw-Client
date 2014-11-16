package businesslogic.RunningTablebl;

import java.util.Vector;

import businesslogic.Salebl.SaleUtilityImpl;
import po.ResultMessage;
import vo.GoodsRecordVO;
import vo.SaleConditionVO;

public class SaleRecord {
	public GoodsRecordVO[]  getSaleTable(SaleConditionVO vo) throws Exception{
		MockSaleUtilityImpl sale=new MockSaleUtilityImpl();
		Vector<GoodsRecordVO> record=sale.querySaleRecord(vo);
		GoodsRecordVO[] result=new GoodsRecordVO[record.size()];
		for(int i=0;i<record.size();i++){
			result[i]=record.get(i);
		}
		return result;
	}
}
