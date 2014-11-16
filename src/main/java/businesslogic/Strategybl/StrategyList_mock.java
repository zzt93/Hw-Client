package businesslogic.Strategybl;

import java.util.ArrayList;

import businesslogicservice.Strategyblservice.Strategy_List_BLservice;
import po.StrategyPO;
import po.GoodsPO;


public class StrategyList_mock implements Strategy_List_BLservice{
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
		//s.setCondition(new Condition());
		//s.setTimePeriod(new TimePeriod());
		//s.setTreatment(new Treatment());
		list.add(s);
		show();
	}

	public ArrayList<StrategyPO> queryValidStrategy(String strategyFliter){
		return null;
	}
	
	public ArrayList<StrategyPO> show(){
		return this.list;
	}
}


