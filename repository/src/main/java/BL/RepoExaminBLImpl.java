package BL;

import java.util.ArrayList;

import GoodsListBLservice.GL_repo_BLImpl;
import GoodsListBLservice.GL_repo_BLservice;
import PO.GoodsListPO;
import PO.GoodsModelPO;
import PO.RepoPO;
import RepoExaminBLservice.RepoExaminBLservice;

public class RepoExaminBLImpl implements RepoExaminBLservice {

	public ArrayList<RepoPO> show() {
		// TODO Auto-generated method stub
		ArrayList<RepoPO> result = new ArrayList<RepoPO>();
		GL_repo_BLservice gl_repo_BLservice = new GL_repo_BLImpl();
		GoodsListPO temp = gl_repo_BLservice.sum();
		
		ArrayList<GoodsModelPO> goodsModelList = temp.
		return result;
	}

}
