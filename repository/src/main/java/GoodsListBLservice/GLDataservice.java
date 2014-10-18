package GoodsListBLservice;

import VO.Goods;

public interface GLDataservice {
	boolean add(Goods goods);
	boolean delete(Goods goods);
	boolean find(String id);
	boolean find(String[] info);
	boolean find(int a);
}
