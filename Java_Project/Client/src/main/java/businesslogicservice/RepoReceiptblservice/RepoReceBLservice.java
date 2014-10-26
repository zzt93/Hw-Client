package businesslogicservice.RepoReceiptblservice;

import po.ResultMesPO;
import vo.Goods;
import vo.Repo_receipt;

public interface RepoReceBLservice {
	Repo_receipt find() throws Exception;
	Repo_receipt showReceipt() throws Exception;
	ResultMesPO input(Goods goods, int amount) throws Exception;
}
