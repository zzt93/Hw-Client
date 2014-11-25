package businesslogicservice.Strategyblservice;

import java.util.ArrayList;

import po.Condition;
import po.GoodsPO;
import po.TimePeriod;
import po.Treatment;

public interface Strategy_New_BLservice {
	void newStrategy(Condition c,Treatment t,TimePeriod tp);
	ArrayList<GoodsPO> goodList(String goodsInfo);
	boolean examine();
}
