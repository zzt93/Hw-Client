package businesslogic.RepoReceiptbl;

import java.util.ArrayList;

import dataservice.RepoReceiptdataservice.RepoReceiptDataService;
import po.GoodsReceiptPO;
import po.ReceiptPO;
import po.RepoReceiptPO;
import vo.GoodsReceiptVO;
import vo.GoodsVO;
import vo.ReceiptConditionVO;
import vo.RepoReceiptVO;
import businesslogicservice.RepoReceiptblservice.RepoReceBLservice;

public class RepoReceiptBLImpl implements RepoReceBLservice {

	RepoReceiptDataService repoReceiptDataService = new RepoReceiptDataImpl();
	
	public ArrayList<RepoReceiptVO> find(ReceiptConditionVO conditionVO) throws Exception {
		//TODO add parameter for ifind
		ArrayList<RepoReceiptPO> temp = repoReceiptDataService.ifind(null).getObj();
		ArrayList<RepoReceiptVO> res = new ArrayList<RepoReceiptVO>();
		for (RepoReceiptPO repoReceiptPO : temp) {
			res.add(new RepoReceiptVO(repoReceiptPO));
		}
		return res;
	}

	/*
	 * for ui(non-Javadoc)
	 * @see businesslogicservice.RepoReceiptblservice.RepoReceBLservice#showRepoReceipt()
	 */
	public ArrayList<RepoReceiptVO> showRepoReceipt() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ArrayList<GoodsReceiptVO> showGoodsReceipt() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * for account(non-Javadoc)
	 * @see businesslogicservice.RepoReceiptblservice.RepoReceBLservice#sendReceipt(vo.ReceiptConditionVO)
	 */
	public ArrayList<ReceiptPO> sendReceipt(ReceiptConditionVO condition) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * for manager(non-Javadoc)
	 * @see businesslogicservice.RepoReceiptblservice.RepoReceBLservice#receive_receipt(po.ReceiptPO)
	 */
	public void receive_receipt(ReceiptPO po) {
		// TODO Auto-generated method stub

	}

	/*
	 * for account and ui(non-Javadoc)
	 * @see businesslogicservice.RepoReceiptblservice.RepoReceBLservice#produceRepoReceipt(java.util.ArrayList)
	 */
	public String produceRepoReceipt(ArrayList<GoodsVO> goods) throws Exception {
		// TODO Auto-generated method stub
		repoReceiptDataService.insert(new RepoReceiptPO(goods.get(0).amount, 0));
		return null;
	}

	@Override
	public boolean produceGoodsReceipt(GoodsReceiptVO goodsVOs)
			throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	public boolean produceRepoReceipt(RepoReceiptVO repoReceiptvo){
		return false;
	}
	
}
