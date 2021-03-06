package businesslogicservice.GoodsListblservice;

import vo.GoodsModelVO;
import vo.GoodsVO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

public interface GLBLservice {
	
	boolean add(GoodsModelVO goods) throws Exception;
	boolean add(ArrayList<GoodsModelVO> goodsA) throws Exception;
	boolean delete(GoodsModelVO goods) throws Exception;
	ArrayList<GoodsModelVO> iSearch(String info) throws RemoteException;
	//ArrayList<GoodsModelVO> iSearch(int amount) throws Exception;
	ArrayList<GoodsModelVO> iSearch(String[] infos) throws RemoteException;
	ArrayList<GoodsVO> eSearch_batch(String id) throws RemoteException;
	GoodsModelVO eSearch_total(String id) throws RemoteException;
	//modify directly in the ui
	//boolean update(GoodsModelVO goods) throws Exception;
	//show the list of goods when enter the main UI
	HashMap<String, ArrayList<GoodsVO> > batch_statistic() throws Exception; 
	HashMap<String, GoodsModelVO > getGoodsModelVOs() throws Exception;
	
	ArrayList<String> type_del() throws RemoteException;
}
