package dzh.blservice.Strategy;

import java.util.ArrayList;

import dzh.po.*;

public class StrategyList {
	private ArrayList<StrategyPO> list;

	public ArrayList<StrategyPO> getList() {
		return list;
	}

	public void setList(ArrayList<StrategyPO> list) {
		this.list = list;
	}
	
	public ArrayList<StrategyPO> returnStrategy(int cusLevel,ArrayList<Goods> goods){
		return this.list;
	}
	public void addStrategy(StrategyPO s){
		s.setCondition(new Condition());
		s.setTimePeriod(new TimePeriod());
		s.setTreatment(new Treatment());
		list.add(s);
	}
}
