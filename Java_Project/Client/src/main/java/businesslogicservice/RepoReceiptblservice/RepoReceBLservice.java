package businesslogicservice.RepoReceiptblservice;

import po.ResultMesPO;
import vo.Goods;
import vo.Repo_receipt;

public interface RepoReceBLservice {
	Repo_receipt find();
	Repo_receipt showReceipt();
	ResultMesPO input(Goods goods, int amount);
}
