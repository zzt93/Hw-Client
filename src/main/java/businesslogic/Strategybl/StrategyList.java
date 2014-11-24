package businesslogic.Strategybl;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.Strategydataservice.StrategyDataService;
import businesslogicservice.Strategyblservice.Strategy_List_BLservice;
import po.StrategyPO;
import po.GoodsPO;
import util.RMIUtility;


public class StrategyList implements Strategy_List_BLservice{
	private ArrayList<StrategyPO> list;
	private static StrategyDataService sds = null; 
	public StrategyList() throws RemoteException, NotBoundException{
		super();
		if(sds == null){
			sds = (StrategyDataService)RMIUtility.getImpl("Strategy");
		}
	}
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
		refresh();
		return this.list;
	}
	@SuppressWarnings("unchecked")
	public void refresh(){
		try {
			if(sds.show().getErrMessage()==null){
				list=(ArrayList<StrategyPO>) sds.show().getObj();
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}
}


