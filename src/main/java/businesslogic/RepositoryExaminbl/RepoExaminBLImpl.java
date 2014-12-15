package businesslogic.RepositoryExaminbl;

import businesslogic.Salebl.SaleUtilityImpl;
import businesslogic.Stockbl.StockUtilityImpl;
import businesslogicservice.RepositoryExaminblservice.RepoExaminBLservice;
import businesslogicservice.Saleblservice.SaleUtility;
import businesslogicservice.Stockblservice.StockUtility;
import dataservice.RepositoryExamindataservice.RepoExaminDataService;
import po.ReceiptType;
import po.SaleReceiptPO;
import po.StockReceiptPO;
import util.RMIUtility;
import vo.GoodsRecordVO;
import vo.InOutRepoVO;
import vo.ReceiptConditionVO;
import vo.SaleConditionVO;

import java.math.BigDecimal;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

public class RepoExaminBLImpl implements RepoExaminBLservice {

	public RepoExaminBLImpl() throws RemoteException, NotBoundException {
		this.repoExaminDataService = (RepoExaminDataService) RMIUtility.getImpl(examin);
	}

	RepoExaminDataService repoExaminDataService;
	static String examin = "repo examin service";


	public InOutRepoVO countInOut(String start, String end) throws Exception {
		BigDecimal in = new BigDecimal(0);
		BigDecimal out = new BigDecimal(0);
		int in_num = 0;
		int out_num = 0;
		InOutRepoVO result;
		StockUtility stock = new StockUtilityImpl();
		SaleUtility sale = new SaleUtilityImpl();
		//TODO add user
		ReceiptConditionVO in_conditionVO = new ReceiptConditionVO(start, end, ReceiptType.STOCK_ACCEPT, null, null, null);
		SaleConditionVO saleConditionVO = new SaleConditionVO();
		saleConditionVO.startTime = start;
		saleConditionVO.endTime = end;


		//get the all in
		List<StockReceiptPO> stock_in = stock.queryReceipt(in_conditionVO);
		in_conditionVO.type = ReceiptType.SALE_REJECTION;
		List<SaleReceiptPO> sale_in = sale.queryReceipt(in_conditionVO);
		
		
		
		//get all out
		ReceiptConditionVO out_condition = new ReceiptConditionVO(start, end, ReceiptType.STOCK_REJECTION, null, null, null);
		List<StockReceiptPO> stock_out = stock.queryReceipt(out_condition);
		out_condition.type = ReceiptType.SALE_ACCEPT;
		List<SaleReceiptPO> sale_out = sale.queryReceipt(out_condition);
		
		

		for (StockReceiptPO stockReceiptPO : stock_in) {
			in.add(stockReceiptPO.getTotalValue());
		}
		for (SaleReceiptPO saleReceiptPO : sale_in) {
			in.add(saleReceiptPO.getTotalValue());
		}
		for (StockReceiptPO saleReceiptPO : stock_out) {
			out.add(saleReceiptPO.getTotalValue());
		}
		for (SaleReceiptPO saleReceiptPO : sale_out) {
			out.add(saleReceiptPO.getTotalValue());
		}
		//count the amount
		List<GoodsRecordVO> goodsRecordVOs = sale
				.querySaleRecord(saleConditionVO);
		for (GoodsRecordVO goodsRecordVO : goodsRecordVOs) {
			switch (goodsRecordVO.type) {
			case STOCK_ACCEPT:
				in_num += goodsRecordVO.number;
				break;
			case STOCK_REJECTION:
				in_num -= goodsRecordVO.number;
				break;
			case SALE_ACCEPT:
				out_num += goodsRecordVO.number;
				break;
			case SALE_REJECTION:
				out_num -= goodsRecordVO.number;
				break;
			default:
				break;
			}
		}
		result = new InOutRepoVO(in, out, in_num, out_num, start, end);
		repoExaminDataService.insert(result);
		return result;
	}

	

	
}
