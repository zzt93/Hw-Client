package businesslogic.GoodsListbl;

import businesslogicservice.GoodsListblservice.GL_GT_BLservice;
import po.GoodsListPO;
import po.GoodsModelPO;

import java.rmi.RemoteException;
import java.util.HashMap;

public class GL_GT_Impl implements GL_GT_BLservice{

	public GoodsListPO goodsListPO() throws RemoteException {
		return GL_controller.goodsListDataService.getGoodsList().getObj();
	}
	public GL_GT_Impl() throws NullPointerException{

	}

	public boolean checkEverHas(String info) throws Exception {
		HashMap<String, GoodsModelPO> goodsModels = goodsListPO().getGoodsModels();
		if (goodsModels.size() == 0){
			return false;
		}
		return goodsModels.get(info).isEverHas();
	}



}
