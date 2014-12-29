package businesslogic.RunningTablebl;

import businesslogic.FinancialReceiptbl.FinReceiptController;
import businesslogic.RepoReceiptbl.RepoReceiptBLImpl;
import businesslogic.Salebl.SaleUtilityImpl;
import businesslogic.Stockbl.StockUtilityImpl;
import po.CashPO;
import po.GoodsReceiptPO;
import po.PayPO;
import po.RecPO;
import po.ReceiptPO;
import po.SaleReceiptPO;
import po.StockReceiptPO;
import vo.*;

import java.util.ArrayList;
import java.util.List;

public class CheckReceipt {
	public ArrayList<ReceiptPO> getReceipt(ReceiptConditionVO vo)throws Exception{
		ArrayList<ReceiptPO> list = new ArrayList<ReceiptPO>();
		switch(vo.type){
			case GOODSRECEIPT:
			case REPORECEIPT:{
				RepoReceiptBLImpl repo=new RepoReceiptBLImpl();
				list=repo.sendReceipt(vo);
				break;
			}
			case SALE_ACCEPT:
			case SALE_REJECTION:{
				SaleUtilityImpl sale=new SaleUtilityImpl();
				List<SaleReceiptPO> temp=sale.queryReceipt(vo);
				for(int i=0;i<temp.size();i++){
					list.add(temp.get(i));
				}
				break;
			}
			case STOCK_ACCEPT:
			case STOCK_REJECTION:{
				StockUtilityImpl stock=new StockUtilityImpl();
				List<StockReceiptPO> temp=stock.queryReceipt(vo);
				for(int i=0;i<temp.size();i++){
					list.add(temp.get(i));
				}
				break;
			}
			case CASH:
			case RECEIVE:
			case PAYMENT:{
				FinReceiptController FinReceipt=new FinReceiptController();
				list=FinReceipt.getReceipt(vo);
				break;
			}
		}
		
		return list;
	}
	public void CreditNote(ReceiptPO po)throws Exception{
		po.number=null;
		po.time=null;
		switch(po.type){
		case GOODSRECEIPT:{
			//FIXME,改成直接传递po
			RepoReceiptBLImpl temp=new RepoReceiptBLImpl();
			temp.produceGoodsReceipt_forAccount((GoodsReceiptPO)po);
			break;
		}
		//FIXME,该红冲是否生成有待商榷
//		case REPORECEIPT:{
//			RepoReceiptBLImpl temp=new RepoReceiptBLImpl();
//			temp.produceRepoReceipt((RepoReceiptVO)vo);
//			break;
//		}
		case SALE_ACCEPT:
		case SALE_REJECTION:{
			SaleUtilityImpl temp=new SaleUtilityImpl();
			temp.makeReceipt((SaleReceiptPO)po);
			break;
		}
		case STOCK_ACCEPT:
		case STOCK_REJECTION:{
			StockUtilityImpl temp=new StockUtilityImpl();
			temp.makeReceipt((StockReceiptPO)po);
			break;
		}
		case CASH:{
			FinReceiptController temp=new FinReceiptController();
			temp.creditCash((CashPO)po);
			break;
		}
		case RECEIVE:
		case PAYMENT:{
			FinReceiptController temp=new FinReceiptController();
			temp.creditRec((RecPO)po);
			break;
		}
		
	}
	}
	
}
