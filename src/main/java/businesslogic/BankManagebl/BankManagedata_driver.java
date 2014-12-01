package businesslogic.BankManagebl;

import po.BankPO;
import po.ResultMessage;
import vo.BankVO;

import java.rmi.RemoteException;

public class BankManagedata_driver {
	ResultMessage result;
	BankPO bank=new BankPO(new BankVO("银行账户3",521,"备注"));
	public void driver(BankManageData_stub bankData){
		try {
			result=bankData.find("right");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		try {
			result=bankData.insert(bank);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		try {
			result=bankData.init();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		try {
			result=bankData.delete(bank);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		try {
			result=bankData.update(bank);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		try {
			result=bankData.finish();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		try {
			result=bankData.finds();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		try {
			result=bankData.setup("账目");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		try {
			result=bankData.getID("账目");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
