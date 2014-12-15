package businesslogic.SetAccountbl;

import po.ResultMessage;

import java.rmi.RemoteException;


public class SetAccountdata_driver {
	ResultMessage result;
	public void driver(SetAccountdata_stub accountData){
		try {
			result=accountData.setup(new String());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		try {
			result=accountData.getGoods();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		try {
			result=accountData.getBank();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		try {
			result=accountData.getClient();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
