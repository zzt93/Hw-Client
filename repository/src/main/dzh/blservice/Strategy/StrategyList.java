package blservice.Strategy;

import java.util.ArrayList;

import po.StrategyPO;

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
}
