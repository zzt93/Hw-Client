package businesslogic.SetAccountbl;

import dataservice.SetAccountdataservice.SetAccountdataservice;
import po.BankPO;
import po.ClientPO;
import po.GoodsPO;
import po.ResultMessage;

import java.rmi.RemoteException;


public class SetAccountdata_stub implements SetAccountdataservice {
	
	@Override
	public ResultMessage setup(String name) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage setDefaultAccount(String name) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage getDefaultAccount() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage getAllAccount() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage inherit(String name) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage creatCopy() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage getGoods() throws RemoteException {
		// TODO Auto-generated method stub
		return new ResultMessage(null,new GoodsPO[5]);
	}

	@Override
	public ResultMessage getBank() throws RemoteException {
		// TODO Auto-generated method stub
		return new ResultMessage(null,new BankPO[5]);
	}

	@Override
	public ResultMessage getClient() throws RemoteException {
		// TODO Auto-generated method stub
		return new ResultMessage(null,new ClientPO[5]);
	}

}
