package businesslogic.BankManagebl;
import businesslogicservice.BankManageblservice.BankManageblservice;
import po.BankPO;
import vo.BankVO;
import po.ResultMessage;

public class BankController implements BankManageblservice{
	BankManage manage=new BankManage();
	public void add(BankVO vo)throws Exception{
		BankPO po=new BankPO(vo);
		ResultMessage result=manage.add(po);
		result.throwIfFailed();
	}
	public void delete(BankVO vo)throws Exception{
		BankPO po=new BankPO(vo);
		ResultMessage result=manage.delete(po);
		result.throwIfFailed();
	}
	public void modify(BankVO vo)throws Exception{
		BankPO po=new BankPO(vo);
		ResultMessage result=manage.modify(po);
		result.throwIfFailed();
	}
	public BankVO[] search(String field)throws Exception{
		ResultMessage result=manage.search(field);
		result.throwIfFailed();
		return (BankVO[])result.getObj();
	}
}
