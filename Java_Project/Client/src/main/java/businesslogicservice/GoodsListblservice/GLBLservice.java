package businesslogicservice.GoodsListblservice;

import java.util.ArrayList;
import java.util.HashMap;

import vo.GoodsFilterVO;
import vo.GoodsVO;

public interface GLBLservice {
	boolean save() throws Exception;//save the state of goodsList
	
	boolean add(GoodsVO goods) throws Exception;
	boolean add(ArrayList<GoodsVO> goodsA) throws Exception;
	boolean delete(GoodsVO goods) throws Exception;
	ArrayList<GoodsVO> iSearch(String info) throws Exception;
	ArrayList<GoodsVO> iSearch(int amount) throws Exception;
	ArrayList<GoodsVO> iSearch(String[] infos) throws Exception;
	ArrayList<GoodsVO> iSearch(GoodsFilterVO filter) throws Exception;
	ArrayList<GoodsVO> eSearch(String id) throws Exception;
	boolean update(GoodsVO goods) throws Exception;
	//show the list of goods when enter the main UI
	HashMap<String, ArrayList<GoodsVO> > show() throws Exception; 
	
	
}
