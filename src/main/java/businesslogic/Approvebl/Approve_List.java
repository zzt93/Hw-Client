package businesslogic.Approvebl;

import businesslogic.FinancialReceiptbl.FinReceiptController;
import businesslogic.RepoReceiptbl.RepoReceiptBLImpl;
import businesslogic.RepoReceiptbl.RepoReceiptDataImpl;
import businesslogic.Salebl.SaleUtilityImpl;
import businesslogic.Stockbl.StockUtilityImpl;
import businesslogicservice.Approveblservice.Approve_List_BLservice;
import businesslogicservice.FinancialReceiptblservice.FinancialReceiptblservice;
import businesslogicservice.Saleblservice.SaleUtility;
import businesslogicservice.Stockblservice.StockUtility;
import dataservice.ApproveDataService.ApproveDataService;
import dataservice.GoodsListdataservice.GoodsListDataService;
import dataservice.RepoReceiptdataservice.RepoReceiptDataService;
import po.*;
import util.RMIUtility;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.Vector;

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
	private <E> void addOneByOne(Vector<E> ver){
		Iterator<E> itR = ver.iterator();
		while(itR.hasNext()){
			receipts.add((ReceiptPO) itR.next());
		}
	}
	@Override
	public ArrayList<ReceiptPO> showList() throws Exception {
		//<yus>
		SaleUtility saleUtility = new SaleUtilityImpl();
		Vector<SaleReceiptPO> verSale = saleUtility.queryReceipt(null);
		addOneByOne(verSale);
		StockUtility stockUtility = new StockUtilityImpl();
		Vector<StockReceiptPO> verStock = stockUtility.queryReceipt(null);
		addOneByOne(verStock);
		//</yus>
		//<zzt>
		RepoReceiptDataService repository = new RepoReceiptDataImpl();
		ArrayList<RepoReceiptPO> arrRepo =repository.getRepoReceipts().getObj();
		receipts.addAll(arrRepo);
		ArrayList<GoodsReceiptPO> arrGoods = repository.getGoodsReceipts().getObj();
		receipts.addAll(arrGoods);
		//</zzt>
		
		//<gda>
		FinReceiptController finreceipt = new FinReceiptController();
		ArrayList<ReceiptPO> arrfin = finreceipt.getReceipt(null);
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

	@Override
	public ArrayList<ReceiptPO> upload() throws Exception {
		// TODO Auto-generated method stub 这个借口不用了。。
		ArrayList<GoodsReceiptPO> goods = new ArrayList<GoodsReceiptPO>();
		ArrayList<RepoReceiptPO> repo = new ArrayList<RepoReceiptPO>();
		ArrayList<SaleReceiptPO> sale = new ArrayList<SaleReceiptPO>();
		ArrayList<StockReceiptPO> stock = new ArrayList<StockReceiptPO>();
		ArrayList<CashPO> cash = new ArrayList<CashPO>();
		ArrayList<PayPO> pay = new ArrayList<PayPO>();
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
				rec.add((RecPO)po);
				break;
			case PAYMENT: 
				pay.add((PayPO)po);
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
	public void upload(ArrayList<ReceiptPO> po){
		ads.uploadReceipt(po);
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
		if(item.equals("Time")){
			
			Collections.sort(receipts, new TimeComparator());
		}
		return receipts;
	}
	
	class TimeComparator implements Comparator<ReceiptPO>{

		@Override
		public int compare(ReceiptPO o1, ReceiptPO o2) {
			return o1.time.compareTo(o2.time);
		}

		
		
	}
	
}
