package businesslogic.Strategybl;

import po.StrategyPO;
import businesslogicservice.Strategyblservice.*;
public class StrategyStub{
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StrategyList sl = new StrategyList();
		StrategyPO spo = new StrategyPO();
		spo.setCondition(new Condition(CatOfCondition.CUSTOMERLEVEL,1));
		spo.setTreatment(new Treatment(CatOfTreatment.COUPON,100));
		sl.addStrategy(spo);
		
		
	}

}