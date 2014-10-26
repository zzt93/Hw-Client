package businesslogicservice.RepoReceiptblservice;

import po.ResultMesPO;
import vo.GoodsVO;
import vo.Repo_receipt;

public interface RepoReceBLservice {
	Repo_receipt find();
	Repo_receipt showReceipt();
	ResultMesPO input(GoodsVO goods, int amount);
}
