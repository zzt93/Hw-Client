package businesslogic.RepositoryCheckbl;

import po.GoodsListPO;
import businesslogicservice.GoodsListblservice.GL_repo_BLservice;

public class Mock_check implements GL_repo_BLservice{

	GoodsListPO goodsListPO = new GoodsListPO();
	
	public GoodsListPO sum() throws Exception {
		return goodsListPO;
	}

}
