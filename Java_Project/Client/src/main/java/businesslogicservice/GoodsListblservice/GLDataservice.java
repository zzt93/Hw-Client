package businesslogicservice.GoodsListblservice;

import vo.GoodsVO;

public interface GLDataservice {
	boolean add(GoodsVO goods);
	boolean delete(GoodsVO goods);
	boolean find(String id);
	boolean find(String[] info);
	boolean find(int a);
}
