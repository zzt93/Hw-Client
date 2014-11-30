package businesslogic.SetAccountbl;

import po.ResultMessage;

import java.rmi.RemoteException;


public class SetAccountdata_driver {
	ResultMessage result;
	public void driver(SetAccountdata_stub accountData){
		try {
			result=accountData.setup(new String[3]);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		try {
			result=accountData.goods();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		try {
			result=accountData.bank();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		try {
			result=accountData.client();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
