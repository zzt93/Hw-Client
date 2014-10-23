package businesslogic.Repositorybl;

import java.util.ArrayList;

import businesslogicservice.Repositoryblservice.RepoExaminBLservice;
import businesslogic.GoodsListbl.GL_repo_BLImpl;
import businesslogicservice.GoodsListblservice.GL_repo_BLservice;
import po.GoodsListPO;
import po.GoodsModelPO;
import po.RepoPO;

public class RepoExaminBLImpl implements RepoExaminBLservice {

	public ArrayList<RepoPO> show() {
		// TODO Auto-generated method stub
		ArrayList<RepoPO> result = new ArrayList<RepoPO>();
		GL_repo_BLservice gl_repo_BLservice = new GL_repo_BLImpl();
		GoodsListPO temp = gl_repo_BLservice.sum();
		
		ArrayList<GoodsModelPO> goodsModelList ;
		return result;
	}

}
