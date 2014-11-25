package businesslogic.GoodsListbl;

import java.rmi.RemoteException;
import java.util.HashMap;

import dataservice.GoodsListdataservice.GoodsListDataService;
import po.GoodsListPO;
import po.GoodsModelPO;
import vo.GoodsVO;
import businesslogicservice.GoodsListblservice.GL_manager_BLservice;
import businesslogicservice.GoodsListblservice.GL_repo_BLservice;

public class GL_manager_repo_Impl implements GL_manager_BLservice, GL_repo_BLservice {

	GoodsListPO goodsListPO;
	GoodsListDataService glDataService = new GoodsListDataImpl("");

	public GL_manager_repo_Impl() throws RemoteException {
		goodsListPO = glDataService.getGoodsList().getObj();
	}
	
	public GoodsListPO sum() throws Exception {
		return goodsListPO;
	}
	
	public int amount(GoodsVO goods) throws Exception {
		HashMap<String, GoodsModelPO> goodsModels = goodsListPO.getGoodsModels();
		GoodsModelPO goodsModel = goodsModels.get(goods.id);
		if (goodsModel == null) {
			return 0;
		}
		return goodsModel.getAmount();
	}

	public GoodsListPO getGoodsList() throws Exception {
		return goodsListPO;
	}

}
