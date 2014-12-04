package businesslogic.Strategybl;

import businesslogic.Clientbl.ClientUtilityImpl;
import businesslogic.GoodsListbl.GL_manager_repo_Impl;
import businesslogic.RepoReceiptbl.RepoReceiptBLImpl;
import businesslogicservice.GoodsListblservice.GL_manager_BLservice;
import businesslogicservice.Strategyblservice.Strategy_List_BLservice;
import dataservice.Strategydataservice.StrategyDataService;
import po.*;
import util.RMIUtility;

import java.math.BigDecimal;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;


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

	public ArrayList<StrategyPO> queryValidStrategy(SaleReceiptPO po) throws Exception {
		ClientUtilityImpl cu = new ClientUtilityImpl();

		ClientPO cl = cu.queryClientById(po.getClientId());
		ArrayList<StrategyPO> pos = new ArrayList<StrategyPO>();
		for (StrategyPO spo : list) {
			if (spo.getCondition().type == CatOfCondition.CUSTOMERLEVEL
					&& spo.getCondition().getCustomerLevel() <= cl.getLevel()
							.ordinal() + 1) {

				pos.add(spo);


			} else if (spo.getCondition().type == CatOfCondition.TOTALPRICE
					&& BigDecimal.valueOf(spo.getCondition().getTotalPrice())
							.compareTo(po.getActualValue()) > 0) {

				pos.add(spo);

			} else if(spo.getCondition().type == CatOfCondition.COMPOSITION){
				ArrayList<GoodsModelPO> goodsPO = spo.getCondition().composition;
				List<ProductsReceipt> products = po.getProductList();
				int temp = 0;
				for(ProductsReceipt pr:products){
					for(GoodsModelPO tempPO:goodsPO){
						if(String.valueOf(pr.getCommodity_id()).equals(tempPO.getId())){
							temp++;
							break;
						}
					}
				}
				if(temp==goodsPO.size()){
					pos.add(spo);
				}
				
			}

		}
		return pos;
	}

	public SaleReceiptPO setTreatment(StrategyPO spo, SaleReceiptPO po) throws Exception {
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
			
			
			po.setComment("有礼品赠送哦亲~^0^");
			GL_manager_BLservice gmb = new  GL_manager_repo_Impl();
			RepoReceiptBLImpl ri = new RepoReceiptBLImpl();
			
			
			
		}
		return po;
		

	}		
	

	
	
}
