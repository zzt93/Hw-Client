package businesslogicservice.Strategyblservice;

import java.util.ArrayList;

import po.StrategyPO;
import po.GoodsPO;


public class StrategyList implements Strategy_List_BLservice{
	private ArrayList<StrategyPO> list;

	public ArrayList<StrategyPO> getList() {
		return list;
	}

	public void setList(ArrayList<StrategyPO> list) {
		this.list = list;
	}
	
	public ArrayList<StrategyPO> returnStrategy(int cusLevel,ArrayList<GoodsPO> goods){
		return this.list;
	}
	public void addStrategy(StrategyPO s){
		s.setCondition(new Condition());
		s.setTimePeriod(new TimePeriod());
		s.setTreatment(new Treatment());
		list.add(s);
	}
}
