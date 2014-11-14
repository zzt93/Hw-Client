package businesslogic.Strategybl;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.Strategydataservice.StrategyDataService;
import po.ResultMessage;
import po.StrategyPO;
import util.RMIUtility;
import vo.GoodsVO;
import businesslogic.GoodsListbl.GLBLImpl;
import businesslogicservice.GoodsListblservice.GLBLservice;
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
	public ArrayList<GoodsVO> goodList(String goodsInfo) {
		// TODO Auto-generated method stub
		GLBLservice glb = new GLBLImpl("account name");// ????????????????

		try {
			return glb.iSearch(goodsInfo);
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
