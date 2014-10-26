package businesslogicservice.GoodsListblservice;

import po.ResultMesPO;
import vo.GoodsVO;
import vo.SignalVO;

public interface GL_signal_BLservice {
	/*check whether some goods is exist and the signal is modifiable*/
	boolean check(GoodsVO goods) throws Exception;
	boolean checkSignalModifiable(GoodsVO goodsVO);
	
	boolean setSignal(GoodsVO goods, int amount) throws Exception;//Hashmap<String(id), int> signalMap
	boolean getSignal(GoodsVO goods)  throws Exception;
	
	SignalVO sendSignal();
	
	ResultMesPO update() throws Exception;
}
