package dataservice.Strategydataservice;

import po.ResultMessage;
import po.StrategyPO;

import java.rmi.RemoteException;

public interface StrategyDataService {
	public ResultMessage confirm(StrategyPO strategyPO) throws RemoteException;
	public ResultMessage show() throws RemoteException;
}
