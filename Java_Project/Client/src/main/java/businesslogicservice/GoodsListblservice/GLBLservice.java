package businesslogicservice.GoodsListblservice;

import java.util.ArrayList;
import java.util.HashMap;

import vo.Goods;

public interface GLBLservice {
	boolean save();//save the state of goodsList
	
	boolean add(Goods goods);
	boolean add(ArrayList<Goods> goodsA);
	boolean delete(Goods goods);
	ArrayList<Goods> iSearch(String info);
	ArrayList<Goods> iSearch(int amount);
	ArrayList<Goods> iSearch(String[] infos);
	ArrayList<Goods> eSearch(String id);
	boolean update(Goods goods);
	//show the list of goods when enter the main UI
	HashMap<String, ArrayList<Goods> > show(); 
	
	
}
