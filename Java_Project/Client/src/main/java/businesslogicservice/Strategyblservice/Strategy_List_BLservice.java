package businesslogicservice.Strategyblservice;

import java.util.ArrayList;

import po.GoodsPO;
import po.StrategyPO;

public interface Strategy_List_BLservice {
	public void addStrategy(StrategyPO s);
	public ArrayList<StrategyPO> returnStrategy(int cusLevel,ArrayList<GoodsPO> goods);
}
