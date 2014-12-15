package businesslogicservice.GoodsListblservice;

import po.GoodsPO;
import vo.GoodsVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

public interface GL_stock_BLservice {
	int amount(GoodsPO goods) throws Exception;
	
	boolean checkGoodsExists(GoodsVO goodsVO) throws Exception;
	ArrayList<String> sell_type() throws RemoteException;
	ArrayList<String> stock_type() throws RemoteException;
//	
//	boolean addAmount(GoodsVO goods) throws Exception;
//	boolean addAmount(ArrayList<GoodsVO> goodsArrayList) throws Exception;
//	boolean reduAmount(GoodsVO goods) throws Exception;
//	boolean reduAmount(ArrayList<GoodsVO> goodsArrayList) throws Exception;
//	
}
