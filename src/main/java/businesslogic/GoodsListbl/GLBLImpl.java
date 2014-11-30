package businesslogic.GoodsListbl;

import businesslogicservice.GoodsListblservice.GLBLservice;
import po.GoodsListPO;
import po.GoodsModelPO;
import po.GoodsPO;
import vo.GoodsModelVO;
import vo.GoodsVO;

import java.util.ArrayList;
import java.util.HashMap;

public class GLBLImpl implements GLBLservice {

	public GLBLImpl(GoodsListPO po) {
		goodsListPO = po;
	}

	GoodsListPO goodsListPO;

	public boolean add(GoodsModelVO goods) throws Exception {
		HashMap<String, GoodsModelPO> tempGoodsModelPOs = goodsListPO
				.getGoodsModels();

		GoodsModelPO goodsModelPO = new GoodsModelPO(goods.getId());
		tempGoodsModelPOs.put(goods.getId(), goodsModelPO);
		return true;
	}

	public boolean add(ArrayList<GoodsModelVO> goodsA) throws Exception {
		for (GoodsModelVO goodsVO : goodsA) {
			add(goodsVO);
		}
		return true;
	}

	public boolean delete(GoodsModelVO goods) throws Exception {
		HashMap<String, GoodsModelPO> tempGoodsModelPOs = goodsListPO
				.getGoodsModels();

		GoodsModelPO temp = tempGoodsModelPOs.get(goods.getId());
		if (temp == null || temp.isEverHas() || temp.getAmount() > 0) {
			return false;
		}
		return true;
	}

	public ArrayList<GoodsModelVO> iSearch(String info) throws Exception {
		ArrayList<GoodsModelVO> res = new ArrayList<GoodsModelVO>();
		HashMap<String, GoodsModelPO> goodsModel = goodsListPO.getGoodsModels();
		for (String id : goodsModel.keySet()) {
			GoodsModelPO temp = goodsModel.get(id);
			if (temp.toString().contains(info)) {
				res.add(new GoodsModelVO(temp));
			}
		}
		return res;
	}

	// TODO whether to use different container to split different infos
	public ArrayList<GoodsModelVO> iSearch(String[] infos) throws Exception {
		ArrayList<GoodsModelVO> res = new ArrayList<GoodsModelVO>();
		HashMap<String, GoodsModelPO> goodsModel = goodsListPO.getGoodsModels();

		for (int i = 0; i < infos.length; i++) {
			String info = infos[i];
			for (String id : goodsModel.keySet()) {
				GoodsModelPO temp = goodsModel.get(id);
				if (temp.toString().contains(info)) {
					res.add(new GoodsModelVO(temp));
				}
			}
		}
		return res;
	}

	public ArrayList<GoodsVO> eSearch_batch(String id) throws Exception {
		ArrayList<GoodsVO> res = new ArrayList<GoodsVO>();

		HashMap<String, ArrayList<GoodsPO>> batch_goodsPO = goodsListPO
				.getGoods();
		ArrayList<GoodsPO> temp = batch_goodsPO.get(id);
		for (GoodsPO goodsPO : temp) {
			res.add(new GoodsVO(goodsPO));
		}
		return res;
	}

	public GoodsModelVO eSearch_total(String id) throws Exception {

		HashMap<String, GoodsModelPO> total = goodsListPO.getGoodsModels();

		return new GoodsModelVO(total.get(id));
	}

	public HashMap<String, ArrayList<GoodsVO>> batch_statistic()
			throws Exception {
		HashMap<String, ArrayList<GoodsVO>> res = new HashMap<String, ArrayList<GoodsVO>>();
		HashMap<String, ArrayList<GoodsPO>> goodsPO = goodsListPO.getGoods();
		for (String id : goodsPO.keySet()) {
			ArrayList<GoodsPO> temp = goodsPO.get(id);
			ArrayList<GoodsVO> temRes = new ArrayList<GoodsVO>();
			for (GoodsPO goodPO : temp) {
				temRes.add(new GoodsVO(goodPO));
			}
			res.put(id, temRes);
		}
		return res;
	}

	public HashMap<String, GoodsModelVO> getGoodsModelVOs() throws Exception {
		HashMap<String, GoodsModelPO> goodsModelPO = goodsListPO
				.getGoodsModels();
		HashMap<String, GoodsModelVO> res = new HashMap<String, GoodsModelVO>();
		for (String id : goodsModelPO.keySet()) {
			res.put(id, new GoodsModelVO(goodsModelPO.get(id)));
		}
		return res;
	}

}
