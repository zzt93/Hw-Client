package businesslogic.RepoReceiptbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

import dataservice.RepoReceiptdataservice.RepoReceiptDataService;
import po.GoodsModelPO;
import po.GoodsPO;
import po.GoodsReceiptPO;
import po.ReceiptPO;
import po.ReceiptState;
import po.ReceiptType;
import po.RepoReceiptPO;
import vo.GoodsModelVO;
import vo.GoodsReceiptVO;
import vo.GoodsVO;
import vo.ReceiptConditionVO;
import vo.RepoReceiptVO;
import businesslogic.GoodsListbl.GL_controller;
import businesslogicservice.RepoReceiptblservice.RepoReceBLservice;

public class RepoReceiptBLImpl implements RepoReceBLservice {

	RepoReceiptDataService repoReceiptDataService = new RepoReceiptDataImpl();
	ArrayList<RepoReceiptPO> repoReceiptPOs ;
	ArrayList<GoodsReceiptPO> goodsReceiptPOs;
	GL_controller gl_controller;
	
	public RepoReceiptBLImpl() throws RemoteException {
		repoReceiptPOs = repoReceiptDataService.getRepoReceipts().getObj();
		goodsReceiptPOs = repoReceiptDataService.getGoodsReceipts().getObj();
		gl_controller = new GL_controller();
	}
	

	/*
	 * for ui(non-Javadoc)
	 * @see businesslogicservice.RepoReceiptblservice.RepoReceBLservice#showRepoReceipt()
	 */
	public ArrayList<RepoReceiptVO> showRepoReceipt() throws Exception {
		ArrayList<RepoReceiptPO> temp = repoReceiptDataService.ifind(null).getObj();
		ArrayList<RepoReceiptVO> res = new ArrayList<RepoReceiptVO>();
		for (RepoReceiptPO repoReceiptPO : temp) {
			res.add(new RepoReceiptVO(repoReceiptPO));
		}
		return res;
	}
	
	@Override
	public ArrayList<GoodsReceiptVO> showGoodsReceipt() throws Exception {
		ArrayList<GoodsReceiptVO> res = new ArrayList<GoodsReceiptVO>();
		for (GoodsReceiptPO goodsReceiptPO : goodsReceiptPOs) {
			res.add(new GoodsReceiptVO(goodsReceiptPO));
		}
		return res;
	}

	/*
	 * for account(non-Javadoc)
	 * @see businesslogicservice.RepoReceiptblservice.RepoReceBLservice#sendReceipt(vo.ReceiptConditionVO)
	 */
	public ArrayList<ReceiptPO> sendReceipt(ReceiptConditionVO condition) throws Exception {
		ArrayList<ReceiptPO> res = new ArrayList<ReceiptPO>();
		//TODO
		
		return res;
	}

	/*
	 * update the goodslist etcetera (non-Javadoc)
	 * @see businesslogicservice.RepoReceiptblservice.RepoReceBLservice#receive_receipt(po.ReceiptPO)
	 */
	public void receive_receipt(ReceiptPO po) throws Exception {
		if (po.statement == ReceiptState.disapprove
				|| po.type != ReceiptType.GOODSRECEIPT
				|| po.type != ReceiptType.REPORECEIPT) {
			return;
		}
		if (po.type == ReceiptType.GOODSRECEIPT) {
			GoodsReceiptPO temp = (GoodsReceiptPO)po;
			for (GoodsPO goodsPO : temp.getGoodsPOs()) {
				gl_controller.reduAmount(new GoodsVO(goodsPO));
			}
		} else {
			RepoReceiptPO temp = (RepoReceiptPO)po;
			int num = temp.getaNum()-temp.getcNum();
			if (num > 0) {
				gl_controller.addAmount(new GoodsVO(temp.getId(), num));
			} else if (temp.getaNum() - temp.getcNum() < 0){
				gl_controller.reduAmount(new GoodsVO(temp.getId(), num));
			} else {
				System.err.println("Something wrong in the repo receipt");
				assert(false);
			}
		}
	}

	/*
	 * for account and ui(non-Javadoc)
	 * @see businesslogicservice.RepoReceiptblservice.RepoReceBLservice#produceRepoReceipt(java.util.ArrayList)
	 */
	public String produceRepoReceipt(ArrayList<GoodsVO> goods) throws Exception {
		for (GoodsVO goodsVO : goods) {
			repoReceiptDataService.insert(new RepoReceiptPO(goodsVO.id, goodsVO.amount, 0));
		}
		return null;
	}

	@Override
	public boolean produceGoodsReceipt(GoodsReceiptVO goodsVOs)
			throws Exception {
		repoReceiptDataService.insert(new GoodsReceiptPO(goodsVOs));
		return true;
	}
	
	@Override
	public ArrayList<GoodsModelVO> showGiftList() throws Exception {
		ArrayList<GoodsModelVO> res = new ArrayList<GoodsModelVO>();
		
		HashMap<String, GoodsModelPO> goodsModels = gl_controller.getGoodsModelPOs();
		for (GoodsModelPO goodsModelPO : goodsModels.values()) {
			if (goodsModelPO.isGift()) {
				res.add(new GoodsModelVO(goodsModelPO));
			}
		}
		
		return res;
	}


	@Override
	public ArrayList<GoodsModelVO> showGoodsList() throws Exception {
		ArrayList<GoodsModelVO> res = new ArrayList<GoodsModelVO>();
		
		HashMap<String, GoodsModelPO> goodsModels = gl_controller.getGoodsModelPOs();
		for (GoodsModelPO goodsModelPO : goodsModels.values()) {
			if (goodsModelPO.getAmount() > 0) {
				res.add(new GoodsModelVO(goodsModelPO));
			}
		}
		
		return res;
	}
	
}
