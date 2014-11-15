package businesslogicservice.Strategyblservice;

import java.util.ArrayList;

import po.GoodsPO;
import po.StrategyPO;

public interface Strategy_New_BLservice {
	StrategyPO newStrategy();
	ArrayList<GoodsPO> goodList(String goodsInfo);
	boolean examine(StrategyPO po);
}
