package businesslogicservice.GoodsListblservice;

import java.util.ArrayList;
import java.util.HashMap;

import vo.GoodsModelVO;




public interface GL_GT_BLservice {
	boolean checkAdd(String info) throws Exception;//check the amount
	boolean checkEverHas(String info) throws Exception;//check whether this goods is ever has
	
	HashMap<String, ArrayList<GoodsModelVO>> getGoodsModels();
	
	void notifyBT();
}
