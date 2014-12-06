package businesslogicservice.GoodsListblservice;

import vo.GoodsVO;
import vo.SignalVO;

public interface GL_signal_BLservice {
	/*check whether some goods is exist and the signal is modifiable*/
	boolean check_signal(GoodsVO goods) throws Exception;
	boolean checkSignalModifiable(GoodsVO goodsVO) throws Exception;
	
	boolean setSignal_name(GoodsVO goods) throws Exception;//Hashmap<String(id), int> signalMap
	int getSignal(GoodsVO goods)  throws Exception;
	
	SignalVO sendSignal(int amout, int signal, String id) throws Exception;
	
	boolean update_when_sale(GoodsVO goodsVO) throws Exception;
}
