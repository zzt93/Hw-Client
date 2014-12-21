package businesslogic.RunningTablebl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import businesslogic.GoodsListbl.GL_controller;
import businesslogic.RepoReceiptbl.RepoReceiptBLImpl;
import businesslogic.RepositoryCheckbl.RepoCheckBLImpl;
import businesslogic.Salebl.SaleUtilityImpl;
import businesslogic.Stockbl.StockUtilityImpl;
import po.GoodsModelPO;
import po.GoodsReceiptPO;
import po.ProductsReceipt;
import po.ReceiptPO;
import po.ReceiptType;
import po.RepoGoods;
import po.RepoPO;
import po.RepoReceiptPO;
import po.SaleReceiptPO;
import po.StockReceiptPO;
import vo.GoodsModelVO;
import vo.GoodsVO;
import vo.ProfitVO;
import vo.ReceiptConditionVO;
import vo.TimeConditionVO;

public class CheckProfit {
	ReceiptConditionVO condition;
	ProfitVO profit;
	
	HashMap<String,Double> goodsPrice;//最近库存均价或者进价
	public ProfitVO getProfit(ReceiptConditionVO vo)throws Exception{
		this.condition=vo;
		profit=new ProfitVO();
		goodsPrice=new HashMap<String,Double>();
		RepoCheckBLImpl repoCheck=new RepoCheckBLImpl();
		RepoPO repoData=repoCheck.get_aver_in();
		//获得商品均价
		if(repoData==null){//没有库存盘点就取进价
			GL_controller controller=new GL_controller();
			Collection<GoodsModelPO> goodsList=controller.getGoodsModelPOs().values();
			for(GoodsModelPO temp:goodsList){
				goodsPrice.put(temp.getId(),temp.getDefault_in());
			}
		}else{//有盘点则取最近盘点的数据
			ArrayList<RepoGoods> repoGoods=repoData.getRepoGoods();
			RepoGoods temp;
			for(int i=0;i<repoGoods.size();i++){
				temp=repoGoods.get(i);
				goodsPrice.put(temp.getId(), temp.getAver_price());
			}
		}
		checkSaleReceipt();
		checkGiftReceipt();
		checkRepoReceipt();
		checkStockReceipt();
		checkCostAdjust();
		profit.calculate();
		return profit;
	}
	private void checkSaleReceipt()throws Exception{
		//TODO，销售收入（顺便计算代金券差价，折让总额），销售成本
		SaleUtilityImpl sale=new SaleUtilityImpl();
		condition.type=ReceiptType.SALE_ACCEPT;
		List<SaleReceiptPO> receipt_list=sale.queryReceipt(condition);
		SaleReceiptPO temp;
		for(int i=0;i<receipt_list.size();i++){
			temp=receipt_list.get(i);
			
			profit.saleIncome+=temp.getActualValue().doubleValue();//销售收入
			double differ=temp.getCoupon().doubleValue()-temp.getActualValue().doubleValue();
			if(differ>0){
				profit.couponDiffer+=differ;
			};//代金券差价
			profit.discount+=temp.getAllowance().doubleValue();//折让总额
			
			//计算销售成本
			List<ProductsReceipt> prList=temp.getProductList();
			ProductsReceipt pr;
			for(int j=0;j<prList.size();j++){
				pr=prList.get(i);
				profit.saleCost+=pr.getNumber()*goodsPrice.get(pr.getCommodity_id());
			}
		}
		//TODO，销售退货是否计算待定
	}
	private void checkRepoReceipt()throws Exception{
		//商品报溢，商品报损收入支出的计算
		List<ReceiptPO> list;
		RepoReceiptBLImpl repo=new RepoReceiptBLImpl();
		condition.type=ReceiptType.REPORECEIPT;
		list=repo.sendReceipt(condition);	
		double overFlow=0,damage=0;
		double temp;
		RepoReceiptPO receipt;
		for(int i=0;i<list.size();i++){
			receipt=(RepoReceiptPO)list.get(i);
			temp=receipt.getaNum()-receipt.getcNum();
			if(temp>0){
				//查询均价，计算
				profit.goodsOverflow+=temp*goodsPrice.get(receipt.getGoods_id());
			}else{
				//同上
				temp=0-temp;
				profit.goodsLost+=temp*goodsPrice.get(receipt.getGoods_id());
			}
		}
	}
	private void checkGiftReceipt()throws Exception{
		//TODO,商品赠送支出
		List<ReceiptPO> list;
		RepoReceiptBLImpl repo=new RepoReceiptBLImpl();
		condition.type=ReceiptType.GOODSRECEIPT;
		list=repo.sendReceipt(condition);
		GoodsReceiptPO temp;
		for(int i=0;i<list.size();i++){
			temp=(GoodsReceiptPO)list.get(i);
			profit.giftCost+=temp.getSumOfGifts();
		}
		
	}
	private void checkStockReceipt() throws Exception{
		//TODO,进货退货差价，
//		List<StockReceiptPO> stockInList;
		List<StockReceiptPO> stockOutList;
		StockUtilityImpl stock=new StockUtilityImpl();
//		condition.type=ReceiptType.STOCK_ACCEPT;
//		stockInList=stock.queryReceipt(condition);
		condition.type=ReceiptType.STOCK_REJECTION;
		stockOutList=stock.queryReceipt(condition);
//		StockReceiptPO temp;
//		for(int i=0;i<stockInList.size();i++){
//			temp=stockInList.get(i);
//			profit.stockDiffer+=temp.getTotalValue().doubleValue();
//		}
//		for(int i=0;i<stockOutList.size();i++){
//			temp=stockOutList.get(i);
//			profit.stockDiffer-=temp.getTotalValue().doubleValue();
//		}
		for(StockReceiptPO receipt:stockOutList){
			for(ProductsReceipt pr:receipt.getProductList()){
				double inPrice=goodsPrice.get(pr.getCommodity_id());
				profit.stockDiffer+=(pr.getPrice().doubleValue()-inPrice)*pr.getNumber();
			}
		}
		
	}
	private void checkCostAdjust() throws Exception{
		//TODO,成本调价
		GL_controller controller=new GL_controller();
		String str=null;
		Collection<GoodsModelPO> goodsModelList=controller.getGoodsModelPOs().values();
		for(GoodsModelPO temp:goodsModelList){
			profit.costAdjust+=temp.getAmount()*(temp.getLastInPrice()-goodsPrice.get(temp.getId()));
		}
	}

}
