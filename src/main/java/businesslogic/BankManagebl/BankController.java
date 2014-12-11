package businesslogic.BankManagebl;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import businesslogicservice.BankManageblservice.BankManageblservice;
import po.BankPO;
import po.ResultMessage;
import vo.BankVO;

public class BankController implements BankManageblservice{
	BankManage manage;
	public BankController() throws RemoteException, NotBoundException{
		manage=new BankManage();
	}
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
		BankVO vo = new BankVO((BankPO) result.getObj());
		return new BankVO[]{vo};
	}
}
