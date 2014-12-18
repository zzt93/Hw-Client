package businesslogic.Approvebl;

import businesslogic.FinancialReceiptbl.FinReceiptController;
import businesslogic.RepoReceiptbl.RepoReceiptBLImpl;
import businesslogic.RepoReceiptbl.RepoReceiptDataImpl;
import businesslogic.Salebl.SaleUtilityImpl;
import businesslogic.Stockbl.StockUtilityImpl;
import businesslogicservice.Approveblservice.Approve_List_BLservice;
import businesslogicservice.FinancialReceiptblservice.FinancialReceiptblservice;
import businesslogicservice.RepoReceiptblservice.RepoReceBLservice;
import businesslogicservice.Saleblservice.SaleUtility;
import businesslogicservice.Stockblservice.StockUtility;
import dataservice.ApproveDataService.ApproveDataService;
import dataservice.GoodsListdataservice.GoodsListDataService;
import dataservice.RepoReceiptdataservice.RepoReceiptDataService;
import po.*;
import util.RMIUtility;
import vo.ReceiptConditionVO;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @author Mebleyev.G.Longinus
 *
 */
public class Approve_List implements Approve_List_BLservice{
	ArrayList<ReceiptPO> receipts = new ArrayList<ReceiptPO>();
	ApproveDataService ads;
	ArrayList<ReceiptPO> screenReceipts = new ArrayList<ReceiptPO>();
	
	public Approve_List() throws RemoteException, NotBoundException{
		if(ads==null){
			ads = (ApproveDataService) RMIUtility.getImpl("Approve");
		}
	}
	private <E> void addOneByOne(List<E> ver){
		Iterator<E> itR = ver.iterator();
		while(itR.hasNext()){
			receipts.add((ReceiptPO) itR.next());
		}
	}
	@Override
	public ArrayList<ReceiptPO> showList() throws Exception {
		//<yus>
		SaleUtility saleUtility = new SaleUtilityImpl();
		List<SaleReceiptPO> verSale = saleUtility.queryReceipt(new ReceiptConditionVO());
		addOneByOne(verSale);
		StockUtility stockUtility = new StockUtilityImpl();
		List<StockReceiptPO> verStock = stockUtility.queryReceipt(new ReceiptConditionVO());
		//FIXME
		addOneByOne(verStock);
		//</yus>
		//<zzt>
		RepoReceiptBLImpl respository = new RepoReceiptBLImpl();
		List<RepoReceiptPO> verRepo = respository.repoReceiptPOs();
		List<GoodsReceiptPO> verGoods = respository.goodsReceiptPOs();
		addOneByOne(verRepo);
		addOneByOne(verGoods);
		//</zzt>
		
		//<gda>
		FinReceiptController finreceipt = new FinReceiptController();
		ArrayList<ReceiptPO> arrfin = finreceipt.getReceipt(new ReceiptConditionVO());
		for(ReceiptPO po :arrfin){
			receipts.add(po);
		}
		//</gda>
		
		

		return this.receipts;
	}

	@Override
	public ArrayList<ReceiptPO> refresh() throws Exception {
		/*
		 * Request new info from 
		 */
		return showList();

	}

	@Override
	public boolean passList(ArrayList<ReceiptPO> array) throws Exception {
		// TODO Auto-generated method stub
		for(ReceiptPO rpo : array){
			if(receipts.contains(rpo)){
				receipts.get(receipts.indexOf(rpo)).statement=ReceiptState.approve;
			}			
		}

		return true;
	}

	
	public ArrayList<ReceiptPO> uploadAbandoned() throws Exception {
		// TODO Auto-generated method stub 这个借口不用了。。
		ArrayList<GoodsReceiptPO> goods = new ArrayList<GoodsReceiptPO>();
		ArrayList<RepoReceiptPO> repo = new ArrayList<RepoReceiptPO>();
		ArrayList<SaleReceiptPO> sale = new ArrayList<SaleReceiptPO>();
		ArrayList<StockReceiptPO> stock = new ArrayList<StockReceiptPO>();
		ArrayList<CashPO> cash = new ArrayList<CashPO>();
//		ArrayList<PayPO> pay = new ArrayList<PayPO>();
		ArrayList<RecPO> rec = new ArrayList<RecPO>();//Receive);
		
		
		for(ReceiptPO po : receipts){
			switch(po.type){
			case STOCK_ACCEPT:
			case STOCK_REJECTION:
				stock.add((StockReceiptPO)po);
				break;
			case SALE_ACCEPT:
			case SALE_REJECTION:
				sale.add((SaleReceiptPO)po);
				break;
			case RECEIVE: 
				//收款单和付款单统一都是RecPO类型，只有type属性不一样
			case PAYMENT: 
				rec.add((RecPO)po);
				break;
			case CASH:
				cash.add((CashPO)po);

				break;
			case REPORECEIPT:
				repo.add((RepoReceiptPO)po);
				break;
			case GOODSRECEIPT:
				goods.add((GoodsReceiptPO)po);
				break;
			}
			
		}
		/*
		 * Lack of Financial Receipts
		 */
		SaleUtility su = new SaleUtilityImpl();
		StockUtility stu = new StockUtilityImpl();
		RepoReceiptDataService rrb = new RepoReceiptDataImpl();
		FinancialReceiptblservice frb = new FinReceiptController();
		return null;
	}

	/**
	 * 11.29
	 * dzh
	 * Interface Changed
	 * @param po
	 */
	@Override
	public void upload(ArrayList<ReceiptPO> po){
		ads.uploadReceipt(po);
		try {
			showList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public String message(String userName) throws Exception {
		return null;
	}

	public ArrayList<ReceiptPO> screen(String item){//ReceiptFilter[] filter
		for(ReceiptPO rpo:receipts){
			if(rpo.statement == ReceiptState.wait||rpo.statement == ReceiptState.disapprove){
				screenReceipts.add(rpo);
			}
		}
		return screenReceipts;
	}
	public ArrayList<ReceiptPO> order(String item){
		if(item.equals("时间")){			
			Collections.sort(receipts, new TimeComparator());
		}else if(item.equals("编号")){
			Collections.sort(receipts,new IdComparator());
		}else if(item.equals("审批状态")){
			Collections.sort(receipts,new StateComparator());
		}
		return receipts;
	}
	
	class TimeComparator implements Comparator<ReceiptPO>{
		@Override
		public int compare(ReceiptPO o1, ReceiptPO o2) {
			return o1.time.compareTo(o2.time);
		}		
	}
	class IdComparator implements Comparator<ReceiptPO>{
		@Override
		public int compare(ReceiptPO o1,ReceiptPO o2){
			return o1.number.compareTo(o2.number);
		}
	}
	class StateComparator implements Comparator<ReceiptPO>{
		@Override
		public int compare(ReceiptPO o1,ReceiptPO o2){
			return -o1.statement.compareTo(o2.statement);//Wait in the front
		}
	}
	
}
