package businesslogic.RepoReceiptbl;

import businesslogic.GoodsListbl.GL_controller;
import businesslogicservice.RepoReceiptblservice.RepoReceBLservice;
import dataservice.RepoReceiptdataservice.RepoReceiptDataService;
import po.*;
import vo.*;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

public class RepoReceiptBLImpl implements RepoReceBLservice {

	RepoReceiptDataService repoReceiptDataService = new RepoReceiptDataImpl();
	ArrayList<RepoReceiptPO> repoReceiptPOs;
	ArrayList<GoodsReceiptPO> goodsReceiptPOs;
	GL_controller gl_controller;

	public RepoReceiptBLImpl() throws RemoteException, NullPointerException {
		repoReceiptPOs = repoReceiptDataService.getRepoReceipts().getObj();
		goodsReceiptPOs = repoReceiptDataService.getGoodsReceipts().getObj();
		gl_controller = new GL_controller();
	}

	public String[] gift_type() {
		HashMap<String, GoodsModelPO> goodsModel = gl_controller
				.getGoodsModelPOs();
		ArrayList<String> temp = new ArrayList<String>();
		for (GoodsModelPO goods : goodsModel.values()) {
			if (goods.isGift()) {
				temp.add(goods.getId() + " " + goods.getName() + " "
						+ goods.getAmount());
			}
		}
		return (String[]) temp.toArray();
	}

	public String[] check_type() {
		HashMap<String, GoodsModelPO> goodsModel = gl_controller
				.getGoodsModelPOs();
		String[] res = new String[goodsModel.size()];
		int i = 0;
		for (GoodsModelPO goods : goodsModel.values()) {
			res[i++] = goods.getId() + " " + goods.getName() + " "
					+ goods.getAmount();
		}
		return res;
	}

	/*
	 * for ui(non-Javadoc)
	 * 
	 * @see
	 * businesslogicservice.RepoReceiptblservice.RepoReceBLservice#showRepoReceipt
	 * ()
	 */
	

	public String[] receipt_ids(){
		String[] res = new String[repoReceiptPOs.size()];
		int i = 0;
		for (RepoReceiptPO receiptPO : repoReceiptPOs) {
			res[i++] = receiptPO.getReceipt_id();
		}
		return  res;
	}
	
	public GoodsReceiptVO show_a_GoodsReceiptVO(int i){
		GoodsReceiptVO res = new GoodsReceiptVO(goodsReceiptPOs.get(i));
		return res;
	}
	public RepoReceiptVO show_a_RepoReceiptVO(int i){
		RepoReceiptVO res = new RepoReceiptVO(repoReceiptPOs.get(i));
		return res;
	}
	public String[] show_goods_rece_id(){
		String[] res = new String[goodsReceiptPOs.size()];
		int i = 0;
		for (GoodsReceiptPO goodsReceiptVO : goodsReceiptPOs) {
			res[i++] = goodsReceiptVO.getId();
		}
		return res;
	}
		
	

	/*
	 * for account and ui(non-Javadoc)
	 * 
	 * @see businesslogicservice.RepoReceiptblservice.RepoReceBLservice#
	 * produceRepoReceipt(java.util.ArrayList)
	 */
	public String produceRepoReceipt(GoodsVO goods)
			throws Exception {
		int amount = gl_controller.amount(new GoodsPO(goods));
		if (amount == goods.amount) {
			return " ";
		} 
		repoReceiptDataService.insert(new RepoReceiptPO(goods.id, goods.amount,
				amount, "user"));//TODO
		String type = "";
		if (amount > goods.amount) {
			type = "报溢单 "+ amount ;
		} else {
			type = "报损单 "+ amount ;
		}
		return type;
	}

	@Override
	public boolean produceGoodsReceipt(GoodsReceiptVO goodsVOs)
			throws Exception {
		repoReceiptDataService.insert(new GoodsReceiptPO(goodsVOs));
		return true;
	}

	

	
	//TODO
	public ArrayList<RepoReceiptVO> showRepoReceipt() throws Exception {//TODO
		ArrayList<RepoReceiptPO> temp = repoReceiptDataService.getRepoReceipts()
				.getObj();
		ArrayList<RepoReceiptVO> res = new ArrayList<RepoReceiptVO>();
		for (RepoReceiptPO repoReceiptPO : temp) {
			res.add(new RepoReceiptVO(repoReceiptPO));
		}
		return res;
	}
	
	@Override
	public ArrayList<GoodsModelVO> showGoodsList() throws Exception {
		ArrayList<GoodsModelVO> res = new ArrayList<GoodsModelVO>();

		HashMap<String, GoodsModelPO> goodsModels = gl_controller
				.getGoodsModelPOs();
		for (GoodsModelPO goodsModelPO : goodsModels.values()) {
			if (goodsModelPO.getAmount() > 0) {
				res.add(new GoodsModelVO(goodsModelPO));
			}
		}

		return res;
	}
	
	@Override
	public ArrayList<GoodsModelVO> showGiftList() throws Exception {
		ArrayList<GoodsModelVO> res = new ArrayList<GoodsModelVO>();

		HashMap<String, GoodsModelPO> goodsModels = gl_controller
				.getGoodsModelPOs();
		for (GoodsModelPO goodsModelPO : goodsModels.values()) {
			if (goodsModelPO.isGift()) {
				res.add(new GoodsModelVO(goodsModelPO));
			}
		}

		return res;
	}

	@Override
	public ArrayList<GoodsReceiptVO> showGoodsReceipt() throws Exception {
		ArrayList<GoodsReceiptVO> res = new ArrayList<GoodsReceiptVO>();
		for (GoodsReceiptPO goodsReceiptPO : goodsReceiptPOs) {
			res.add(goodsReceiptPO.getGoodsReceiptVO());//TODO
		}
		return res;
	}
	/*
	 * for account(non-Javadoc)
	 * 
	 * @see
	 * businesslogicservice.RepoReceiptblservice.RepoReceBLservice#sendReceipt
	 * (vo.ReceiptConditionVO)
	 */
	public ArrayList<ReceiptPO> sendReceipt(ReceiptConditionVO condition)
			throws Exception {
		ArrayList<ReceiptPO> res = new ArrayList<ReceiptPO>();
		// TODO

		return res;
	}


}
