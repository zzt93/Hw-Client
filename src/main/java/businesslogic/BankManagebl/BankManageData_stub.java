package businesslogic.BankManagebl;

import java.rmi.RemoteException;

import dataservice.BankManagedataservice.BankManagedataservice;
import po.BankPO;
import po.ResultMessage;
import vo.BankVO;

public class BankManageData_stub implements BankManagedataservice {

	public ResultMessage find(String field) throws RemoteException{
		if(field.equals("right"))
		return new ResultMessage(null,new BankPO(new BankVO("银行账户1",3000,"备注")));
		else 
		return new ResultMessage("没找到该账户",null);
	}
	public ResultMessage insert(BankPO po) throws RemoteException{
		System.out.println("添加成功");
		return new ResultMessage(null,null);
	}
	public ResultMessage delete(BankPO po) throws RemoteException{
		System.out.println("删除成功");
		return new ResultMessage(null,null);
	}
	public ResultMessage update(BankPO po) throws RemoteException{
		System.out.println("更新成功");
		return new ResultMessage(null,null);
	}
	public  ResultMessage init() throws RemoteException{
		System.out.println("初始化成功");
		return new ResultMessage(null,null);
	}

	public ResultMessage finish() throws RemoteException {
		System.out.println("结束数据库使用");
		return new ResultMessage(null,null);
	}

	public ResultMessage finds() throws RemoteException {
		return new ResultMessage(null,new BankPO[5]);
	}

	public ResultMessage setup(String account) throws RemoteException{
		System.out.println("新建数据库成功");
		return new ResultMessage(null,null);
	}

	public ResultMessage getID(String account) throws RemoteException {
		// TODO Auto-generated method stub
		return new ResultMessage(null,"账目1");
	}

}
