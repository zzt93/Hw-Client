package businesslogic.Strategybl;

import businesslogic.Clientbl.ClientUtilityImpl;
import businesslogic.RepoReceiptbl.RepoReceiptBLImpl;
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
		refresh();
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

	public void addStrategy(StrategyPO s) throws RemoteException {
		list.add(s);
		show();
	}

//	public ArrayList<StrategyPO> queryValidStrategy(String strategyFliter) {
//		return null;
//	}

	public ArrayList<StrategyPO> show() throws RemoteException {
		refresh();
		return this.list;
	}

	@SuppressWarnings("unchecked")
	public void refresh() throws RemoteException {
		if (sds.show().getErrMessage() == null) {
			list = (ArrayList<StrategyPO>) sds.show().getObj();
		}else{
			System.out.println(sds.show().getErrMessage());
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
							.compareTo(po.getTotalValue()) < 0) {

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
			po.setActualValue(po.getTotalValue().subtract(po.getAllowance()));
			po.setCoupon(new BigDecimal(0));
			bd.add(BigDecimal
					.valueOf(spo.getTreatment().getDiscount()));
		}
		if (spo.getTreatment().type == CatOfTreatment.COUPON) {
			po.setCoupon(BigDecimal.valueOf(spo.getTreatment().getCoupon()));
			po.setActualValue(po.getTotalValue());
			po.setAllowance(new BigDecimal(0));
			bd.add(BigDecimal
					.valueOf(spo.getTreatment().getCoupon()));
		}
		if (spo.getTreatment().type == CatOfTreatment.GIVE) {
			po.setAllowance(new BigDecimal(0));
			po.setCoupon(new BigDecimal(0));
			po.setActualValue(po.getTotalValue());
			po.setComment("有礼品赠送哦亲~^0^"+spo.getTreatment().toString());
			//FIXME 赠品还没有实现
			
			
		}
		po.setStrategyId(spo.getStrategyId());
		return po;
		

	}		
	

	
	
}
