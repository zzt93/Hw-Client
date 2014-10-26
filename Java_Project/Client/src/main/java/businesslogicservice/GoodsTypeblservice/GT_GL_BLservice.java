package businesslogicservice.GoodsTypeblservice;

import vo.Goods;

public interface GT_GL_BLservice {
	boolean typeCheck(Goods goods) throws Exception;//used to check whether it is a leaf node
	
}
