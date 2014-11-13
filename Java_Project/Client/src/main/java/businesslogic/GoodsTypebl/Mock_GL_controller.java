package businesslogic.GoodsTypebl;

import java.util.ArrayList;
import java.util.HashMap;

import po.GoodsListPO;
import vo.GoodsListVO;
import vo.GoodsModelVO;
import businesslogicservice.GoodsListblservice.GL_GT_BLservice;

public class Mock_GL_controller implements GL_GT_BLservice{
	
	ArrayList<GoodsModelVO> goodsModelVOs = new ArrayList<GoodsModelVO>(null);
	GoodsListPO goodsListPO = new GoodsListPO();

	public boolean checkAdd(String info) throws Exception {
		for (GoodsModelVO goodsModelVO : goodsModelVOs) {
			if (goodsModelVO.getId().equals(info)) {
				return goodsModelVO.getAmount() == 0;
			}
		}
		return false;
	}

	public boolean checkEverHas(String info) throws Exception {
		for (GoodsModelVO goodsModelVO : goodsModelVOs) {
			if(goodsModelVO.getId().equals(info)){
				return goodsModelVO.isEverHas();
			}
		}
		return false;
	}

	public HashMap<String, GoodsModelVO> getGoodsModels() {
		return new GoodsListVO(goodsListPO).getGoodsModels();
	}

	public void notifyBT() {
		
	}

}
