package RepoReceipt;

import VO.Goods;
import VO.Repo_receipt;
import VO.ResultMes;

public interface RepoReceBLservice {
	Repo_receipt find();
	Repo_receipt showReceipt();
	ResultMes input(Goods goods, int amount);
}
