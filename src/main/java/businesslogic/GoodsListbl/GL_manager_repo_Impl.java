package businesslogic.GoodsListbl;

import businesslogicservice.GoodsListblservice.GL_manager_BLservice;
import businesslogicservice.GoodsListblservice.GL_repo_BLservice;
import javax.swing.JOptionPane;

import dataservice.GoodsListdataservice.GoodsListDataService;
import po.GoodsListPO;
import po.GoodsModelPO;
import presentation.RepoUI.MainFrame;
import util.RMIUtility;
import vo.GoodsVO;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.HashMap;

public class GL_manager_repo_Impl implements GL_manager_BLservice, GL_repo_BLservice {


	GoodsListDataService glDataService;



	public GL_manager_repo_Impl() throws RemoteException, NullPointerException, NotBoundException {
		glDataService = (GoodsListDataService) RMIUtility.getImpl(GL_controller.gl_service);

	}
	

	
	public int amount(GoodsVO goods) throws Exception {
		HashMap<String, GoodsModelPO> goodsModels = getGoodsList().getGoodsModels();
		GoodsModelPO goodsModel = goodsModels.get(goods.id);
		if (goodsModel == null) {
			return 0;
		}
		return goodsModel.getAmount();
	}

	public GoodsListPO getGoodsList() throws Exception {
		return glDataService.getGoodsList().getObj();
	}

}
