package businesslogicservice.GoodsTypeblservice;

import vo.GoodsVO;

public interface GT_GL_BLservice {
	boolean typeCheck(GoodsVO goods);//used to check whether it is a leaf node
	
}
