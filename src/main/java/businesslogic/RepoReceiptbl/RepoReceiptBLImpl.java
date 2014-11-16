package businesslogic.RepoReceiptbl;

import java.util.ArrayList;

import dataservice.RepoReceiptdataservice.RepoReceiptDataService;
import po.GoodsReceiptPO;
import po.ReceiptPO;
import po.RepoReceiptPO;
import vo.GoodsVO;
import vo.ReceiptConditionVO;
import vo.RepoReceVO;
import businesslogicservice.RepoReceiptblservice.RepoReceBLservice;

public class RepoReceiptBLImpl implements RepoReceBLservice {

	RepoReceiptDataService repoReceiptDataService = new RepoReceiptDataImpl();
	
	public ArrayList<RepoReceVO> find(ReceiptConditionVO conditionVO) throws Exception {
		//TODO add parameter for ifind
		ArrayList<RepoReceiptPO> temp = repoReceiptDataService.ifind(null).getObj();
		ArrayList<RepoReceVO> res = new ArrayList<RepoReceVO>();
		for (RepoReceiptPO repoReceiptPO : temp) {
			res.add(new RepoReceVO(repoReceiptPO));
		}
		return res;
	}

	public RepoReceVO showReceipt() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public RepoReceVO sendReceipt() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public void receive_receipt(ReceiptPO po) {
		// TODO Auto-generated method stub

	}

	public String input(GoodsVO goods) throws Exception {
		// TODO Auto-generated method stub
		repoReceiptDataService.insert(new RepoReceiptPO(goods.amount, 0));
		return null;
	}


	public GoodsReceiptPO giftReceipt() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
