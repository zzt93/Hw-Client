package businesslogic.RunningTablebl;

import java.util.ArrayList;
import java.util.Vector;
import businesslogic.FinancialReceiptbl.FinReceiptController;
import businesslogic.RepoReceiptbl.RepoReceiptBLImpl;
import businesslogic.Salebl.SaleUtilityImpl;
import businesslogic.Stockbl.StockUtilityImpl;
import po.RecPO;
import po.ReceiptPO;
import po.ReceiptType;
import po.SaleReceiptPO;
import po.StockReceiptPO;
import vo.CashVO;
import vo.GoodsReceiptVO;
import vo.GoodsVO;
import vo.PayVO;
import vo.RecVO;
import vo.ReceiptConditionVO;
import vo.RepoReceiptVO;

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
				Vector<SaleReceiptPO> temp=sale.queryReceipt(vo);
				for(int i=0;i<temp.size();i++){
					list.add(temp.get(i));
				}
				break;
			}
			case STOCK_ACCEPT:
			case STOCK_REJECTION:{
				StockUtilityImpl stock=new StockUtilityImpl();
				Vector<StockReceiptPO> temp=stock.queryReceipt(vo);
				for(int i=0;i<temp.size();i++){
					list.add(temp.get(i));
				}
				break;
			}
			case CASH:
			case RECEIVE:
			case PAYMENT:{
				MockFinReceiptController FinReceipt=new MockFinReceiptController();
				list=FinReceipt.getReceipt(vo);
				break;
			}
		}
		
		return list;
	}
	public void CreditNote(ReceiptPO vo)throws Exception{
		switch(vo.type){
		case GOODSRECEIPT:{
			RepoReceiptBLImpl temp=new RepoReceiptBLImpl();
			temp.produceGoodsReceipt((GoodsReceiptVO)vo);
			break;
		}
		case REPORECEIPT:{
			RepoReceiptBLImpl temp=new RepoReceiptBLImpl();
			temp.produceRepoReceipt((RepoReceiptVO)vo);
			break;
		}
		case SALE_ACCEPT:
		case SALE_REJECTION:{
			SaleUtilityImpl temp=new SaleUtilityImpl();
			temp.makeReceipt((SaleReceiptPO)vo);
			break;
		}
		case STOCK_ACCEPT:
		case STOCK_REJECTION:{
			StockUtilityImpl temp=new StockUtilityImpl();
			temp.makeReceipt((StockReceiptPO)vo);
			break;
		}
		case CASH:{
			MockFinReceiptController temp=new MockFinReceiptController();
			temp.creditCash((CashVO)vo);
			break;
		}
		case RECEIVE:{
			FinReceiptController temp=new FinReceiptController();
			temp.creditRec((RecVO)vo);
			break;
		}
		case PAYMENT:{
			FinReceiptController temp=new FinReceiptController();
			temp.creditPay((PayVO)vo);
			break;
		}
	}
	}
	
}
