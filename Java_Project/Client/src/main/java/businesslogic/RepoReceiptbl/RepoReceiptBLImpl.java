package businesslogic.RepoReceiptbl;

import dataservice.RepoReceiptdataservice.RepoReceiptDataImpl;
import dataservice.RepoReceiptdataservice.RepoReceiptDataService;
import po.ReceiptPO;
import po.RepoReceiptPO;
import vo.GoodsVO;
import vo.ReceiptConditionVO;
import vo.Repo_receipt;
import businesslogicservice.RepoReceiptblservice.RepoReceBLservice;

public class RepoReceiptBLImpl implements RepoReceBLservice {

	RepoReceiptDataService repoReceiptDataService = new RepoReceiptDataImpl();
	
	public Repo_receipt find(ReceiptConditionVO conditionVO) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public Repo_receipt showReceipt() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public Repo_receipt sendReceipt() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public void receive_receipt(ReceiptPO po) {
		// TODO Auto-generated method stub

	}

	public String input(GoodsVO goods, int amount) throws Exception {
		// TODO Auto-generated method stub
		repoReceiptDataService.insert(new RepoReceiptPO());
		return null;
	}

}
