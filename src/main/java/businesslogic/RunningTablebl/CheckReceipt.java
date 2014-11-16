package businesslogic.RunningTablebl;

import po.RecPO;
import po.ReceiptPO;
import vo.RecVO;
import vo.ReceiptConditionVO;
import vo.ReceiptVO;

public class CheckReceipt {
	ReceiptList<ReceiptPO> list=new ReceiptList<ReceiptPO>();
	public ReceiptPO[] getReceipt(ReceiptConditionVO vo)throws Exception{
		//根据条件从各人员获得单据
		ReceiptPO[] receipt=new ReceiptPO[10];
		return receipt;
	}
	public void CreditNote(ReceiptVO vo)throws Exception{
		//做类型转换
		//调用生成单据方法
	}
	
}
