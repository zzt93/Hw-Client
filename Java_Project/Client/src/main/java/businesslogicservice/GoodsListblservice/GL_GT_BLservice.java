package businesslogicservice.GoodsListblservice;


public interface GL_GT_BLservice {
	boolean checkAdd(String info) throws Exception;//check the amount
	boolean checkDel(String info) throws Exception;//check whether this goods is ever has
}
