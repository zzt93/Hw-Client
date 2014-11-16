package businesslogic.Strategybl;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.GoodsPO;
import po.StrategyPO;
import businesslogicservice.Strategyblservice.Strategy_List_BLservice;
import businesslogicservice.Strategyblservice.Strategy_New_BLservice;

public class StrategyController implements Strategy_New_BLservice,Strategy_List_BLservice{
	StrategyNew sn;
	StrategyList_mock sb = new StrategyList_mock();
	public StrategyController(){
		try {
			sn = new StrategyNew();
		} catch (RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void addStrategy(StrategyPO s) throws Exception {
		sb.addStrategy(s);
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<StrategyPO> returnStrategy(int cusLevel,
			ArrayList<GoodsPO> goods) throws Exception {
		// TODO Auto-generated method stub
		return sb.returnStrategy(cusLevel, goods);
	}

	@Override
	public void newStrategy() {
		// TODO Auto-generated method stub
		sn.newStrategy();
	}

	@Override
	public ArrayList<GoodsPO> goodList(String goodsInfo) {
		// TODO Auto-generated method stub
		return sn.goodList(goodsInfo);
	}

	@Override
	public boolean examine() {
		// TODO Auto-generated method stub
		return sn.examine();
	}

	boolean confirm(){
		return sn.confirm();
	}
}