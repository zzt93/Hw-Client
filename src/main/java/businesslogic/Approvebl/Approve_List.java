package businesslogic.Approvebl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import dataservice.RepoReceiptdataservice.RepoReceiptDataService;
import po.GoodsReceiptPO;
import po.ReceiptPO;
import po.ReceiptState;
import po.RepoReceiptPO;
import po.SaleReceiptPO;
import po.StockReceiptPO;
import businesslogic.FinancialReceiptbl.FinReceiptController;
import businesslogic.RepoReceiptbl.RepoReceiptDataImpl;
import businesslogic.Salebl.SaleUtilityImpl;
import businesslogic.Stockbl.StockUtilityImpl;
import businesslogicservice.Approveblservice.Approve_List_BLservice;
import businesslogicservice.FinancialReceiptblservice.FinancialReceiptblservice;
import businesslogicservice.Saleblservice.SaleUtility;
import businesslogicservice.Stockblservice.StockUtility;

/**
 * @author Mebleyev.G.Longinus
 *
 */
public class Approve_List implements Approve_List_BLservice{
	ArrayList<ReceiptPO> receipts = new ArrayList<ReceiptPO>();
	
	private <E> void addOneByOne(Vector<E> ver){
		Iterator<E> itR = ver.iterator();
		while(itR.hasNext()){
			receipts.add((ReceiptPO) itR.next());
		}
	}
	@Override
	public ArrayList<ReceiptPO> showList() throws Exception {
		SaleUtility su = new SaleUtilityImpl();
		Vector<SaleReceiptPO> verSale = su.queryReceipt(null);
		addOneByOne(verSale);
		StockUtility stu = new StockUtilityImpl();
		Vector<StockReceiptPO> verStock = stu.queryReceipt(null);
		addOneByOne(verStock);
		RepoReceiptDataService rrb = new RepoReceiptDataImpl();
		ArrayList<RepoReceiptPO> arrRepo =rrb.getRepoReceipts().getObj();
		receipts.addAll(arrRepo);
		FinancialReceiptblservice frb = new FinReceiptController();
		
		//Interface not provided;
		
		
		/*
		 * Another ?
		 */
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
		// TODO Auto-generated method stub
		ArrayList<GoodsReceiptPO> goods = new ArrayList<GoodsReceiptPO>();
		ArrayList<RepoReceiptPO> repo = new ArrayList<RepoReceiptPO>();
		ArrayList<SaleReceiptPO> sale = new ArrayList<SaleReceiptPO>();
		ArrayList<StockReceiptPO> stock = new ArrayList<StockReceiptPO>();
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
			case PAYMENT: 
			case CASH:
				/*
				 * Interface not provided!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1
				 */
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

	@Override
	public String message(String userName) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<ReceiptPO> screen(String item){//ReceiptFilter[] filter
		return null;
	}
	public ArrayList<ReceiptPO> order(String item){
		return null;
	}

	
}
