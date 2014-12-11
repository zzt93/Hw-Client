package businesslogic.RunningTablebl;

import java.util.List;

import businesslogic.RepoReceiptbl.RepoReceiptBLImpl;
import po.ReceiptPO;
import po.ReceiptType;
import po.RepoReceiptPO;
import vo.ProfitVO;
import vo.ReceiptConditionVO;
import vo.TimeConditionVO;

public class CheckProfit {
	
	ProfitVO profit;
	double saleIncome,saleCost,goodsOverflow,goodsLost,
			costAdjust,stockDifference,couponDifference,discount,giftCost;
	public ProfitVO getProfit(TimeConditionVO vo)throws Exception{
		return null;
	}
	private void CheckSaleReceipt()throws Exception{
		//TODO，销售收入（顺便计算代金券差价，折让总额），销售成本
		
	}
	private void checkRepoReceipt()throws Exception{
		//TODO,商品报溢，商品报损收入支出的计算
		List<ReceiptPO> list;
		ReceiptConditionVO condition=new ReceiptConditionVO(ReceiptType.REPORECEIPT);
		RepoReceiptBLImpl repo=new RepoReceiptBLImpl();
		list=repo.sendReceipt(condition);
		double overFlow=0,damage=0;
		double temp;
		RepoReceiptPO receipt;
		for(int i=0;i<list.size();i++){
			receipt=(RepoReceiptPO)list.get(i);
			temp=receipt.getaNum()-receipt.getcNum();
			if(temp>0){
				//查询均价，计算
			}else{
				//同上
			}
		}
	}
	private void checkGiftReceipt()throws Exception{
		//TODO,商品赠送支出
	}
	private void checkStockReceipt() throws Exception{
		//TODO,进货退货差价，
	}
	private void checkCost() throws Exception{
		//TODO,成本调价
	}

}
