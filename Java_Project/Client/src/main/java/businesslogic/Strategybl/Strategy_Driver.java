package businesslogic.Strategybl;

import po.StrategyPO;
public class Strategy_Driver{
	
	public void drive(StrategyList_Stub sl,StrategyPO spo){
		spo.setCondition(new Condition(CatOfCondition.CUSTOMERLEVEL,1));
		spo.setTreatment(new Treatment(CatOfTreatment.COUPON,100));
		sl.addStrategy(spo);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Strategy_Driver().drive(new StrategyList_Stub(), new StrategyPO());
		
	}

}
