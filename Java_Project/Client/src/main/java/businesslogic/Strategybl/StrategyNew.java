package businesslogic.Strategybl;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import dataservice.Strategydataservice.StrategyDataService;
import po.GoodsPO;
import po.ResultMessage;
import po.StrategyPO;
import util.RMIUtility;
import businesslogic.GoodsListbl.GL_manager_repo_Impl;
import businesslogicservice.GoodsListblservice.GL_manager_BLservice;
import businesslogicservice.Strategyblservice.Strategy_New_BLservice;

public class StrategyNew implements Strategy_New_BLservice {
	
	private static StrategyDataService sds = null; 
	
	public StrategyNew() throws RemoteException, NotBoundException{
		super();
		if(sds == null){
			sds = (StrategyDataService)RMIUtility.getImpl("Strategy");
		}
	}
	@Override
	public StrategyPO newStrategy() {

		return new StrategyPO();
	}

	@Override
	public ArrayList<GoodsPO> goodList(String goodsInfo) {
		// TODO Auto-generated method stub
		GL_manager_BLservice glb = new GL_manager_repo_Impl();// ????????????????

		
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
	public boolean examine(StrategyPO po) {
		if (po.getTimePeriod().getStart().getTime() > po.getTimePeriod()
				.getStart().getTime()) {
			return false;
		} else if (po.getCondition().totalPrice != 0
				&& po.getTreatment().discount != 0) {
			if (po.getCondition().totalPrice <= po.getTreatment().discount)
				return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	boolean confirm(StrategyPO po){
		ResultMessage<StrategyPO> rm = null;
		try {
			rm = sds.confirm(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(rm.getErrMessage()==null){
			return true;
		}else{
			return false;
		}
	}
}
