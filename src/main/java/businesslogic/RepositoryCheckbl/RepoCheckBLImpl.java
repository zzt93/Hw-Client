package businesslogic.RepositoryCheckbl;

import java.util.ArrayList;
import java.util.HashMap;

import businesslogicservice.RepositoryCheckblservice.RepoCheckBLservice;
import businesslogic.GoodsListbl.GL_manager_repo_Impl;
import businesslogicservice.GoodsListblservice.GL_repo_BLservice;
import po.GoodsListPO;
import po.GoodsModelPO;
import po.RepoPO;

public class RepoCheckBLImpl implements RepoCheckBLservice {

	GL_repo_BLservice gl_repo_BLservice ;
	public RepoCheckBLImpl(GL_repo_BLservice gl_repo_BLservice) {
		this.gl_repo_BLservice = gl_repo_BLservice;
	}

	public ArrayList<RepoPO> checkAndSum() {
		// TODO Auto-generated method stub
		ArrayList<RepoPO> result = new ArrayList<RepoPO>();
		
		GoodsListPO temp = null;
		try {
			temp = gl_repo_BLservice.sum();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		HashMap<String, GoodsModelPO> goodsModelList = temp.getGoodsModels();
		return result;

	}

}
