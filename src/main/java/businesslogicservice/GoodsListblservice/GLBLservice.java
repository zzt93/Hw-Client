package businesslogicservice.GoodsListblservice;

import java.util.ArrayList;
import java.util.HashMap;

import vo.GoodsModelVO;
import vo.GoodsVO;

public interface GLBLservice {
	
	boolean add(GoodsVO goods) throws Exception;
	boolean add(ArrayList<GoodsVO> goodsA) throws Exception;
	boolean delete(GoodsVO goods) throws Exception;
	ArrayList<GoodsVO> iSearch(String info) throws Exception;
	//ArrayList<GoodsVO> iSearch(int amount) throws Exception;
	ArrayList<GoodsVO> iSearch(String[] infos) throws Exception;
	ArrayList<GoodsVO> eSearch_batch(String id) throws Exception;
	GoodsModelVO eSearch_total(String id)throws Exception;
	//modify directly in the ui
	//boolean update(GoodsVO goods) throws Exception;
	//show the list of goods when enter the main UI
	HashMap<String, ArrayList<GoodsVO> > batch_statistic() throws Exception; 
	HashMap<String, GoodsModelVO > getGoodsModelVOs() throws Exception;
	
	
}
