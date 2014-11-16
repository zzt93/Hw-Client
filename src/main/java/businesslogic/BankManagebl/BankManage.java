package businesslogic.BankManagebl;
import po.BankPO;
import po.ResultMessage;
import vo.BankVO;
public class BankManage {
	public ResultMessage add(BankPO po){
		//添加操作
		return new ResultMessage("error",null);
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
		BankVO[] list=new BankVO[1];
		list[0]=new BankVO(new BankPO());
		return new ResultMessage<BankVO[]>(null,list);
	}
}
