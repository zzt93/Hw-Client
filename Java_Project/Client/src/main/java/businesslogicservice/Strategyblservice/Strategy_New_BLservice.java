package businesslogicservice.Strategyblservice;

import java.util.ArrayList;

import po.StrategyPO;
import vo.GoodsVO;

public interface Strategy_New_BLservice {
	StrategyPO newStrategy();
	ArrayList<GoodsVO> goodList(String goodsInfo);
	boolean examine(StrategyPO po);
}
