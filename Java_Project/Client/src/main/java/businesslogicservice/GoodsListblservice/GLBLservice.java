package businesslogicservice.GoodsListblservice;

import java.util.ArrayList;
import java.util.HashMap;

import vo.GoodsVO;

public interface GLBLservice {
	boolean save();//save the state of goodsList
	
	boolean add(GoodsVO goods);
	boolean add(ArrayList<GoodsVO> goodsA);
	boolean delete(GoodsVO goods);
	ArrayList<GoodsVO> iSearch(String info);
	ArrayList<GoodsVO> iSearch(int amount);
	ArrayList<GoodsVO> iSearch(String[] infos);
	ArrayList<GoodsVO> eSearch(String id);
	boolean update(GoodsVO goods);
	//show the list of goods when enter the main UI
	HashMap<String, ArrayList<GoodsVO> > show(); 
	
	
}
