package businesslogicservice.GoodsListblservice;

import java.util.ArrayList;
import java.util.HashMap;

import vo.Goods;

public interface GLBLservice {
	boolean save() throws Exception;//save the state of goodsList
	
	boolean add(Goods goods) throws Exception;
	boolean add(ArrayList<Goods> goodsA) throws Exception;
	boolean delete(Goods goods) throws Exception;
	ArrayList<Goods> iSearch(String info) throws Exception;
	ArrayList<Goods> iSearch(int amount) throws Exception;
	ArrayList<Goods> iSearch(String[] infos) throws Exception;
	ArrayList<Goods> eSearch(String id) throws Exception;
	boolean update(Goods goods) throws Exception;
	//show the list of goods when enter the main UI
	HashMap<String, ArrayList<Goods> > show() throws Exception; 
	
	
}
