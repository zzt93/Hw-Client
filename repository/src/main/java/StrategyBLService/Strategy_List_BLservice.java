package StrategyBLService;

import java.util.ArrayList;

import PO.GoodsPO;
import PO.StrategyPO;

public interface Strategy_List_BLservice {
	public void addStrategy(StrategyPO s);
	public ArrayList<StrategyPO> returnStrategy(int cusLevel,ArrayList<GoodsPO> goods);
}
