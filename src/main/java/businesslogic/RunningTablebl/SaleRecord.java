package businesslogic.RunningTablebl;

import vo.GoodsRecordVO;
import vo.SaleConditionVO;

import java.util.List;

public class SaleRecord {
	public GoodsRecordVO[]  getSaleTable(SaleConditionVO vo) throws Exception{
		MockSaleUtilityImpl sale=new MockSaleUtilityImpl();
		List<GoodsRecordVO> record=sale.querySaleRecord(vo);
		GoodsRecordVO[] result=new GoodsRecordVO[record.size()];
		for(int i=0;i<record.size();i++){
			result[i]=record.get(i);
		}
		return result;
	}
}
