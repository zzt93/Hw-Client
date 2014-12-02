package businesslogic.BankManagebl;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import po.BankPO;
import po.ResultMessage;
import vo.BankVO;

public class MockBankManage extends BankManage{
	public MockBankManage() throws RemoteException, NotBoundException {
		super();
		// TODO Auto-generated constructor stub
	}
	public ResultMessage add(BankPO po){
		return new ResultMessage("测试异常抛出",null);
	}
	public ResultMessage search(String filed){
		//查询操作
		if(filed.equals("测试")){
			BankVO[] list=new BankVO[1];
			list[0]=new BankVO();
			return new ResultMessage<BankVO[]>(null,list);
		}
		return new ResultMessage<BankVO[]>(null,null);
	}
}
