package businesslogic.GoodsTypebl;

import java.util.ArrayList;
import java.util.HashMap;

import po.GoodsListPO;
import po.GoodsModelPO;
import vo.GoodsModelVO;
import businesslogicservice.GoodsListblservice.GL_GT_BLservice;

public class Mock_GL_controller implements GL_GT_BLservice{
	
	ArrayList<GoodsModelVO> goodsModelVOs = new ArrayList<GoodsModelVO>(null);
	GoodsListPO goodsListPO = new GoodsListPO();

	
	public boolean checkEverHas(String info) throws Exception {
		for (GoodsModelVO goodsModelVO : goodsModelVOs) {
			if(goodsModelVO.getId().equals(info)){
				return goodsModelVO.isEverHas();
			}
		}
		return false;
	}

	public HashMap<String, GoodsModelPO> getGoodsModelPOs() {
		return goodsListPO.getGoodsModels();
	}

	public void notifyBT() {
		
	}

}
