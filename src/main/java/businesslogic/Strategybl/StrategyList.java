package businesslogic.Strategybl;

import java.math.BigDecimal;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.Strategydataservice.StrategyDataService;
import businesslogic.Clientbl.ClientUtilityImpl;
import businesslogic.GoodsListbl.GL_manager_repo_Impl;
import businesslogicservice.GoodsListblservice.GL_manager_BLservice;
import businesslogicservice.Strategyblservice.Strategy_List_BLservice;
import po.*;
import util.RMIUtility;
import vo.CashVO;

public class StrategyList implements Strategy_List_BLservice {
	private ArrayList<StrategyPO> list;
	private static StrategyDataService sds = null;

	public StrategyList() throws RemoteException, NotBoundException {
		super();
		if (sds == null) {
			sds = (StrategyDataService) RMIUtility.getImpl("Strategy");
		}
	}

	public ArrayList<StrategyPO> getList() {
		return list;
	}

	public void setList(ArrayList<StrategyPO> list) {
		this.list = list;
	}

	public ArrayList<StrategyPO> returnStrategy(int cusLevel,
			ArrayList<GoodsPO> goods) {
		return this.list;
	}

	public void addStrategy(StrategyPO s) {
		// s.setCondition(new Condition());
		// s.setTimePeriod(new TimePeriod());
		// s.setTreatment(new Treatment());
		list.add(s);
		show();
	}

	public ArrayList<StrategyPO> queryValidStrategy(String strategyFliter) {
		return null;
	}

	public ArrayList<StrategyPO> show() {
		refresh();
		return this.list;
	}

	@SuppressWarnings("unchecked")
	public void refresh() {
		try {
			if (sds.show().getErrMessage() == null) {
				list = (ArrayList<StrategyPO>) sds.show().getObj();
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}

	public ArrayList<SaleReceiptPO> usingStrategy(SaleReceiptPO po) throws Exception {
		ClientUtilityImpl cu = new ClientUtilityImpl();

		ClientPO cl = cu.queryClientById(po.getClientId());
		ArrayList<SaleReceiptPO> pos = new ArrayList<SaleReceiptPO>();
		for (StrategyPO spo : list) {
			if (spo.getCondition().type == CatOfCondition.CUSTOMERLEVEL
					&& spo.getCondition().getCustomerLevel() <= cl.getLevel()
							.ordinal() + 1) {
				SaleReceiptPO npo = new SaleReceiptPO(po);
				setTreatment(spo, npo);

				pos.add(po);


			} else if (spo.getCondition().type == CatOfCondition.TOTALPRICE
					&& BigDecimal.valueOf(spo.getCondition().getTotalPrice())
							.compareTo(po.getActualValue()) > 0) {
				SaleReceiptPO npo = new SaleReceiptPO(po);
				setTreatment(spo,npo);
				pos.add(po);

			} else if(spo.getCondition().type == CatOfCondition.COMPOSITION){
				GL_manager_BLservice gmb = new GL_manager_repo_Impl();
				GoodsListPO gpo = gmb.getGoodsList();
				
			}

		}
		return pos;
	}

	BigDecimal setTreatment(StrategyPO spo, SaleReceiptPO po) {
		BigDecimal bd = new BigDecimal(0);
		if (spo.getTreatment().type == CatOfTreatment.DISCOUNT) {
			po.setAllowance(BigDecimal
					.valueOf(spo.getTreatment().getDiscount()));
			bd.add(BigDecimal
					.valueOf(spo.getTreatment().getDiscount()));
		}
		if (spo.getTreatment().type == CatOfTreatment.COUPON) {
			po.setCoupon(BigDecimal.valueOf(spo.getTreatment().getCoupon()));
			bd.add(BigDecimal
					.valueOf(spo.getTreatment().getCoupon()));
		}
		if (spo.getTreatment().type == CatOfTreatment.GIVE) {

		}
		return bd;
	}

}
