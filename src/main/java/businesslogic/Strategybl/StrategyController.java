package businesslogic.Strategybl;

import businesslogicservice.Strategyblservice.Strategy_List_BLservice;
import businesslogicservice.Strategyblservice.Strategy_New_BLservice;
import po.*;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class StrategyController implements Strategy_New_BLservice,Strategy_List_BLservice{
	StrategyNew sn;
	StrategyList sb;
	public StrategyController(){
		try {
			sn = new StrategyNew();
			sb = new StrategyList();
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
	public void newStrategy(Condition c,Treatment t,TimePeriod tp) {
		// TODO Auto-generated method stub
		sn.newStrategy(c,t,tp);
	}

	@Override
	public ArrayList<GoodsPO> goodList(String goodsInfo) {
		// TODO Auto-generated method stub
		try {
			return sn.goodList(goodsInfo);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return null;
	}

	@Override
	public boolean examine() {
		// TODO Auto-generated method stub
		return sn.examine();
	}

	boolean confirm(){
		return sn.confirm();
	}
	@Override
	public ArrayList<StrategyPO> show() throws Exception {
		// TODO Auto-generated method stub
		return sb.show();
	}
	@Override
	public ArrayList<StrategyPO> queryValidStrategy(String fliters) {
		// TODO Auto-generated method stub
		return sb.queryValidStrategy(fliters);
	}
	@Override
	public SaleReceiptPO setTreatment(StrategyPO spo, SaleReceiptPO po)
			throws Exception {
		// TODO Auto-generated method stub
		return sb.setTreatment(spo, po);
	}
}
