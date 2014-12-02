package dataservice.Strategydataservice;

import po.ResultMessage;
import po.StrategyPO;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface StrategyDataService extends Remote {
	public ResultMessage confirm(StrategyPO strategyPO) throws RemoteException;
	public ResultMessage show() throws RemoteException;
}
