package businesslogic.RepoReceiptbl;

import businesslogic.GoodsListbl.GL_controller;
import businesslogicservice.RepoReceiptblservice.RepoReceBLservice;
import dataservice.RepoReceiptdataservice.RepoReceiptDataService;
import po.*;
import util.RMIUtility;
import vo.*;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

public class RepoReceiptBLImpl implements RepoReceBLservice {

	RepoReceiptDataService repoReceiptDataService ;
	public ArrayList<RepoReceiptPO> repoReceiptPOs() throws RemoteException {
		return repoReceiptDataService.getRepoReceipts(new ReceiptConditionVO()).getObj();
	}
	public ArrayList<GoodsReceiptPO> goodsReceiptPOs() throws RemoteException {
		return repoReceiptDataService.getGoodsReceipts(new ReceiptConditionVO()).getObj();
	}
	GL_controller gl_controller;

	static String receipt = "receipt";

	public RepoReceiptBLImpl() throws RemoteException, NullPointerException, NotBoundException {
		repoReceiptDataService = (RepoReceiptDataService) RMIUtility.getImpl(receipt);
		
		gl_controller = new GL_controller();
	}

	public String[] gift_type() throws RemoteException {
		HashMap<String, GoodsModelPO> goodsModel = gl_controller
				.getGoodsModelPOs();
		ArrayList<String> temp = new ArrayList<String>();
		for (GoodsModelPO goods : goodsModel.values()) {
			if (goods.isGift()) {
				temp.add(goods.getId() + " " + goods.getName() + " "
						+ goods.getAmount());
			}
		}
		return temp.toArray(new String[temp.size()]);
	}

	public static String check_type_id_name = ":";
	public String[] check_type() throws RemoteException {
		HashMap<String, GoodsModelPO> goodsModel = gl_controller
				.getGoodsModelPOs();
		String[] res = new String[goodsModel.size()];
		int i = 0;
		for (GoodsModelPO goods : goodsModel.values()) {
			res[i++] = goods.getId() + check_type_id_name + goods.getName();
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
	

	public String[] receipt_ids() throws RemoteException {
		String[] res = new String[repoReceiptPOs().size()];
		int i = 0;
		for (RepoReceiptPO receiptPO : repoReceiptPOs()) {
			res[i++] = receiptPO.getReceipt_id();
		}
		return  res;
	}
	
	public GoodsReceiptVO show_a_GoodsReceiptVO(int i) throws RemoteException {
		GoodsReceiptVO res = new GoodsReceiptVO(goodsReceiptPOs().get(i));
		return res;
	}
	public RepoReceiptVO show_a_RepoReceiptVO(int i) throws RemoteException {
		RepoReceiptVO res = new RepoReceiptVO(repoReceiptPOs().get(i));
		return res;
	}
	public String[] show_goods_rece_id() throws RemoteException {
		String[] res = new String[goodsReceiptPOs().size()];
		int i = 0;
		for (GoodsReceiptPO goodsReceiptVO : goodsReceiptPOs()) {
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
				amount, "user"));//TODO how to get user
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

	

	
	
	public ArrayList<RepoReceiptVO> showRepoReceipt() throws Exception {
		ArrayList<RepoReceiptPO> temp = repoReceiptDataService.getRepoReceipts(null)
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
		for (GoodsReceiptPO goodsReceiptPO : goodsReceiptPOs()) {
			res.add(new GoodsReceiptVO(goodsReceiptPO));
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
		
		for (ReceiptPO receiptPO : repoReceiptDataService.getGoodsReceipts(condition).getObj()) {
			res.add(receiptPO);
		}
		for (ReceiptPO receiptPO : repoReceiptDataService.getRepoReceipts(condition).getObj()) {
			res.add(receiptPO);
		}
		return res;
	}


}
