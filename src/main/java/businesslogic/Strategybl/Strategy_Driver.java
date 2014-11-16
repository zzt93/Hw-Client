package businesslogic.Strategybl;

import po.CatOfCondition;
import po.CatOfTreatment;
import po.Condition;
import po.StrategyPO;
import po.Treatment;
public class Strategy_Driver{
	
	public void drive(StrategyList_mock sl,StrategyPO spo){
		spo.setCondition(new Condition(CatOfCondition.CUSTOMERLEVEL,1));
		spo.setTreatment(new Treatment(CatOfTreatment.COUPON,100));
		sl.addStrategy(spo);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Strategy_Driver().drive(new StrategyList_mock(), new StrategyPO());
		
	}

}
