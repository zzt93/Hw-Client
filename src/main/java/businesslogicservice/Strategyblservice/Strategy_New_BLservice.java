package businesslogicservice.Strategyblservice;

import po.Condition;
import po.GoodsPO;
import po.TimePeriod;
import po.Treatment;

import java.rmi.RemoteException;
import java.util.ArrayList;

public interface Strategy_New_BLservice {
	void newStrategy(Condition c,Treatment t,TimePeriod tp);
	ArrayList<GoodsPO> goodList(String goodsInfo) throws RemoteException;
	boolean examine();
	boolean confirm();
}
