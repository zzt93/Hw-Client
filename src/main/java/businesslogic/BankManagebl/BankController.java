package businesslogic.BankManagebl;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

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
		Object obj = result.getObj();
		BankVO[] vos;
		if (obj instanceof BankPO) {
			BankVO vo = new BankVO((BankPO) result.getObj());
			vos = new BankVO[]{vo};
		} else {
			List<BankPO> list = (List<BankPO>) obj;
			vos = new BankVO[list.size()];
			for (int i = 0; i < list.size(); ++i) {
				vos[i] = new BankVO(list.get(i));
			}
		}

		return vos;
	}
}
