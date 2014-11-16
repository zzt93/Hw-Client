package businesslogic.BankManagebl;
import po.BankPO;
import po.ResultMessage;
import vo.BankVO;
public class BankManage {
	public ResultMessage add(BankPO po){
		//添加操作
		return new ResultMessage(null,null);
	}
	public ResultMessage delete(BankPO po){
		//删除操作
		return new ResultMessage(null,null);
	}
	public ResultMessage modify(BankPO po){
		//修改操作
		return new ResultMessage(null,null);	
	}
	public ResultMessage search(String filed){
		//查询操作
		return new ResultMessage<BankVO[]>(null,null);
	}
}
