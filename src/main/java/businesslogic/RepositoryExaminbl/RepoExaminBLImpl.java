package businesslogic.RepositoryExaminbl;

import java.math.BigDecimal;
import java.util.Vector;

import po.InOutRepoPO;
import po.StockReceiptPO;
import vo.ReceiptConditionVO;
import businesslogic.Stockbl.StockUtilityImpl;
import businesslogicservice.RepositoryExaminblservice.RepoExaminBLservice;
import businesslogicservice.Stockblservice.StockUtility;

public class RepoExaminBLImpl implements RepoExaminBLservice {

	

	public InOutRepoPO countInOut(String start, String end) throws Exception {
		// TODO Auto-generated method stub
		BigDecimal money = new BigDecimal(0);
		int num = 0;
		InOutRepoPO result;
		StockUtility stock = new StockUtilityImpl();
		
		ReceiptConditionVO conditionVO = new ReceiptConditionVO();
		
		Vector<StockReceiptPO> stockReceiptPOs = stock.queryReceipt(conditionVO);
		for (StockReceiptPO stockReceiptPO : stockReceiptPOs) {
			money.add(stockReceiptPO.getTotalValue());
			//TODO add statistic of num
		}
		result = new InOutRepoPO(money, num);
		return result;
	}

}
