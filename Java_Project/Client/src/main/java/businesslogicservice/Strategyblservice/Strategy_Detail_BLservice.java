package businesslogicservice.Strategyblservice;

import po.GoodsPO;
import po.StrategyPO;

public interface Strategy_Detail_BLservice {
	StrategyPO newStrategy();
	public GoodsPO[] goodList();
	boolean examine();
}
