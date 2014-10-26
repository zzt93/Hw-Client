package businesslogicservice.RepoReceiptblservice;

import po.ResultMesPO;
import vo.GoodsVO;
import vo.Repo_receipt;

public interface RepoReceBLservice {
	Repo_receipt find() throws Exception;
	Repo_receipt showReceipt() throws Exception;
	ResultMesPO input(GoodsVO goods, int amount) throws Exception;
}
