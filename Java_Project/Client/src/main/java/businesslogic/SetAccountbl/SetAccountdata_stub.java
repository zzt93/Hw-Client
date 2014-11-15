package businesslogic.SetAccountbl;

import java.rmi.RemoteException;

import dataservice.SetAccountdataservice.SetAccountdataservice;
import po.*;


public class SetAccountdata_stub implements SetAccountdataservice {
	public ResultMessage setup(String[] name) throws RemoteException {
		return new ResultMessage(null,null);
	}

	public ResultMessage goods() throws RemoteException {
		return new ResultMessage(null,new GoodsPO[5]);
	}

	public ResultMessage bank() throws RemoteException {
		return new ResultMessage(null,new BankPO[5]);
	}

	public ResultMessage client() throws RemoteException {
		return new ResultMessage(null,new ClientPO[5]);
	}

}
