package businesslogic.Strategybl;

import businesslogic.GoodsListbl.GL_manager_repo_Impl;
import businesslogicservice.GoodsListblservice.GL_manager_BLservice;
import businesslogicservice.Strategyblservice.Strategy_New_BLservice;
import dataservice.Strategydataservice.StrategyDataService;
import po.*;
import util.RMIUtility;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

public class StrategyNew implements Strategy_New_BLservice {
	
	private static StrategyDataService strategyData = null; 
	
	StrategyPO po;

	public StrategyNew() throws RemoteException, NotBoundException{
		super();
		if(strategyData == null){
			strategyData = (StrategyDataService)RMIUtility.getImpl("Strategy");
		}
	}
	@Override
	public void newStrategy(Condition c,Treatment t,TimePeriod tp) {

		this.po = new StrategyPO(c,t,tp);
	}

	@Override
	public ArrayList<GoodsPO> goodList(String goodsInfo) throws RemoteException {
		// TODO Auto-generated method stub
		GL_manager_BLservice glb = null;
		try {
			glb = new GL_manager_repo_Impl();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}// ????????????????
		//parameter:GoodsFilter[] filters
		
		try {
			ArrayList<GoodsPO> arrgpo = new ArrayList<GoodsPO>();
			Iterator<ArrayList<GoodsPO>> it = glb.getGoodsList().getGoods().values().iterator();
			while(it.hasNext()){
				arrgpo.addAll(it.next());
			}return arrgpo;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean examine() {
		if (po.getTimePeriod().getStart().getTime() > po.getTimePeriod()
				.getEnd().getTime()) {
			return false;
		} else if (po.getCondition().totalPrice != 0
				&& po.getTreatment().discount != 0) {
			if (po.getCondition().totalPrice <= po.getTreatment().discount)
				return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	public boolean confirm(){
		ResultMessage<StrategyPO> rm = null;
		try {
			rm = strategyData.confirm(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		if(rm.getErrMessage()==null){
			return true;
		}else{
			return false;
		}
	}
}
