package businesslogicservice.Strategyblservice;

import po.GoodsPO;
import po.SaleReceiptPO;
import po.StrategyPO;

import java.util.ArrayList;

public interface Strategy_List_BLservice {
	public void addStrategy(StrategyPO s) throws Exception;
	public ArrayList<StrategyPO> show() throws Exception;
	public ArrayList<StrategyPO> returnStrategy
		(int cusLevel,ArrayList<GoodsPO> goods) throws Exception;
	public ArrayList<StrategyPO> queryValidStrategy(SaleReceiptPO po) throws Exception;
	public SaleReceiptPO setTreatment(StrategyPO spo, SaleReceiptPO po) throws Exception;
}
