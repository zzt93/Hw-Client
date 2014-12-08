package businesslogic.GoodsListbl;

import businesslogicservice.GoodsListblservice.GL_account_BLservice;
import po.GoodsListPO;
import vo.GoodsModelVO;

import java.util.ArrayList;

public class GL_account_Impl implements GL_account_BLservice {

	GoodsListPO goodsListPO;
	public GL_account_Impl(GoodsListPO goodsListPO) {
		this.goodsListPO = goodsListPO;
	}

	public GoodsListPO initialize(String account) throws Exception {
		return new GoodsListPO();
	}

	/*
	 * (non-Javadoc)
	 * @see businesslogicservice.GoodsListblservice.GL_account_BLservice#add(vo.GoodsVO)
	 * those following two methods are ignored
	 */
	public boolean add(GoodsModelVO goodsVO) throws Exception {
		System.err.println("This method shouldn't be invoked");
		System.exit(0);
		return false;
	}

	public boolean add(ArrayList<GoodsModelVO> goodsVOs) throws Exception {
		System.err.println("This method shouldn't be invoked");
		System.exit(0);
		return false;
	}

//	public String getDatabase(String account) throws Exception {
//		// 
//		return null;
//	}

}
