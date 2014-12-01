package businesslogic.RepositoryExaminbl;

import java.math.BigDecimal;
import java.util.Vector;

import dataservice.RepositoryExamindataservice.RepoExaminDataService;
import po.SaleReceiptPO;
import po.StockReceiptPO;
import vo.GoodsRecordVO;
import vo.InOutRepoVO;
import vo.ReceiptConditionVO;
import vo.SaleConditionVO;
import businesslogic.Salebl.SaleUtilityImpl;
import businesslogic.Stockbl.StockUtilityImpl;
import businesslogicservice.RepositoryExaminblservice.RepoExaminBLservice;
import businesslogicservice.Saleblservice.SaleUtility;
import businesslogicservice.Stockblservice.StockUtility;

public class RepoExaminBLImpl implements RepoExaminBLservice {

	RepoExaminDataService repoExaminDataService = new RepoExamDataImpl();

	public InOutRepoVO countInOut(String start, String end) throws Exception {
		// TODO Auto-generated method stub
		BigDecimal in = new BigDecimal(0);
		BigDecimal out = new BigDecimal(0);
		int in_num = 0;
		int out_num = 0;
		InOutRepoVO result;
		StockUtility stock = new StockUtilityImpl();
		SaleUtility sale = new SaleUtilityImpl();

		ReceiptConditionVO conditionVO = new ReceiptConditionVO();
		SaleConditionVO saleConditionVO = new SaleConditionVO();

		Vector<StockReceiptPO> stockReceiptPOs = stock
				.queryReceipt(conditionVO);
		Vector<SaleReceiptPO> saleReceiptPOs = sale.queryReceipt(conditionVO);
		Vector<GoodsRecordVO> goodsRecordVOs = sale
				.querySaleRecord(saleConditionVO);

		for (StockReceiptPO stockReceiptPO : stockReceiptPOs) {
			out.add(stockReceiptPO.getTotalValue());
		}
		for (SaleReceiptPO saleReceiptPO : saleReceiptPOs) {
			in.add(saleReceiptPO.getTotalValue());
		}
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

	public void refresh() throws Exception {
		// TODO
	}

	public void synchronize() throws Exception {
		// TODO
	}

}
