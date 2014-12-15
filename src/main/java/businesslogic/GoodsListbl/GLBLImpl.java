package businesslogic.GoodsListbl;

import businesslogicservice.GoodsListblservice.GLBLservice;
import po.GoodsListPO;
import po.GoodsModelPO;
import po.GoodsPO;
import vo.GoodsModelVO;
import vo.GoodsVO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

public class GLBLImpl implements GLBLservice {

	public GLBLImpl(GoodsListPO po) {
		
	}



	public boolean add(GoodsModelVO goods) throws Exception {
		HashMap<String, GoodsModelPO> tempGoodsModelPOs = GL_controller.goodsListDataService.getGoodsList().getObj()
				.getGoodsModels();
		if (tempGoodsModelPOs.get(goods.getId()) != null){
			return false;
		}
//		GoodsModelPO goodsModelPO = new GoodsModelPO(goods.getId(), goods.getName(), goods.getModel());
//		tempGoodsModelPOs.put(goods.getId(), goodsModelPO);
		return true;
	}

	public boolean add(ArrayList<GoodsModelVO> goodsA) throws Exception {
		for (GoodsModelVO goodsVO : goodsA) {
			add(goodsVO);
		}
		return true;
	}

	public boolean delete(GoodsModelVO goods) throws Exception {
		HashMap<String, GoodsModelPO> tempGoodsModelPOs = GL_controller.goodsListDataService.getGoodsList().getObj()
				.getGoodsModels();

		GoodsModelPO temp = tempGoodsModelPOs.get(goods.getId());
		if (is_del(temp)) {
			return false;
		}
		tempGoodsModelPOs.remove(goods.getId());
		return true;
	}

	public ArrayList<GoodsModelVO> iSearch(String info) throws RemoteException{
		if (info == null){
			return null;
		}
		ArrayList<GoodsModelVO> res = new ArrayList<GoodsModelVO>();
		HashMap<String, GoodsModelPO> goodsModel = GL_controller.goodsListDataService.getGoodsList().getObj().getGoodsModels();
		for (String id : goodsModel.keySet()) {
			GoodsModelPO temp = goodsModel.get(id);
			if (temp.toString().contains(info)) {
				res.add(new GoodsModelVO(temp));
			}
		}
		return res;
	}

	// TODO whether to use different container to split different infos
	public ArrayList<GoodsModelVO> iSearch(String[] infos) throws RemoteException {
		if (infos == null){
			return null;
		}
		ArrayList<GoodsModelVO> res = new ArrayList<GoodsModelVO>();
		HashMap<String, GoodsModelPO> goodsModel = GL_controller.goodsListDataService.getGoodsList().getObj().getGoodsModels();

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

	public ArrayList<GoodsVO> eSearch_batch(String id) throws RemoteException{
		if (id == null){
			return null;
		}
		ArrayList<GoodsVO> res = new ArrayList<GoodsVO>();

		HashMap<String, ArrayList<GoodsPO>> batch_goodsPO = GL_controller.goodsListDataService.getGoodsList().getObj()
				.getGoods();
		ArrayList<GoodsPO> temp = batch_goodsPO.get(id);
		for (GoodsPO goodsPO : temp) {
			res.add(new GoodsVO(goodsPO));
		}
		return res;
	}

	public GoodsModelVO eSearch_total(String id) throws RemoteException{
		if (id == null){
			return null;
		}
		HashMap<String, GoodsModelPO> total = GL_controller.goodsListDataService.getGoodsList().getObj().getGoodsModels();
		GoodsModelPO temp = total.get(id);
		if (temp == null){
			return null;
		}
		return new GoodsModelVO(total.get(id));
	}

	public HashMap<String, ArrayList<GoodsVO>> batch_statistic()
			throws Exception {
		HashMap<String, ArrayList<GoodsVO>> res = new HashMap<String, ArrayList<GoodsVO>>();
		HashMap<String, ArrayList<GoodsPO>> goodsPO = GL_controller.goodsListDataService.getGoodsList().getObj().getGoods();
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
		HashMap<String, GoodsModelPO> goodsModelPO = GL_controller.goodsListDataService.getGoodsList().getObj()
				.getGoodsModels();
		HashMap<String, GoodsModelVO> res = new HashMap<String, GoodsModelVO>();
		for (String id : goodsModelPO.keySet()) {
			res.put(id, new GoodsModelVO(goodsModelPO.get(id)));
		}
		return res;
	}

	private boolean is_del(GoodsModelPO temp){
		if (temp == null || temp.isEverHas() || temp.getAmount() > 0) {
			return false;
		}
		return true;
	}
	@Override
	public ArrayList<String> type_del() throws RemoteException {
		ArrayList<String> res = new ArrayList<String>();
		for (GoodsModelPO model : GL_controller.goodsListDataService.getGoodsList().getObj().getGoodsModels().values()) {
			if (is_del(model)) {
				res.add(model.getId());
			}
		}
		return res;
	}

}
