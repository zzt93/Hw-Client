package businesslogicservice.RepoReceiptblservice;

import po.ReceiptPO;
import po.ResultMesPO;
import vo.GoodsVO;
import vo.ReceiptConditionVO;
import vo.Repo_receipt;

public interface RepoReceBLservice {
	
	Repo_receipt find(ReceiptConditionVO conditionVO) throws Exception;
	Repo_receipt showReceipt() throws Exception;
	Repo_receipt sendReceipt() throws Exception;
	
	void receive_receipt(ReceiptPO po);
	
	ResultMesPO input(GoodsVO goods, int amount) throws Exception;
}
