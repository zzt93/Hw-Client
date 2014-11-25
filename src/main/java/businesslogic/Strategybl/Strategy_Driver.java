package businesslogic.Strategybl;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import po.CatOfCondition;
import po.CatOfTreatment;
import po.Condition;
import po.StrategyPO;
import po.Treatment;
public class Strategy_Driver{
	
	public void drive(StrategyList sl,StrategyPO spo){
		spo.setCondition(new Condition(CatOfCondition.CUSTOMERLEVEL,1));
		spo.setTreatment(new Treatment(CatOfTreatment.COUPON,100));
		sl.addStrategy(spo);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			new Strategy_Driver().drive(new StrategyList(), new StrategyPO(null,null,null));
		} catch (RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
