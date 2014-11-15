package dataservice.Strategydataservice;

import java.rmi.RemoteException;

import po.*;

public interface StrategyDataService {
	public ResultMessage confirm(StrategyPO strategyPO) throws RemoteException;
	public ResultMessage show() throws RemoteException;
}
