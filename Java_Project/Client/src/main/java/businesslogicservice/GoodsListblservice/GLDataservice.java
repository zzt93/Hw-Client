package businesslogicservice.GoodsListblservice;

import vo.Goods;

public interface GLDataservice {
	boolean add(Goods goods) throws Exception;
	boolean delete(Goods goods) throws Exception;
	boolean find(String id) throws Exception;
	boolean find(String[] info) throws Exception;
	boolean find(int a) throws Exception;
}
