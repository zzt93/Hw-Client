package businesslogicservice.GoodsListblservice;

import po.ResultMesPO;
import vo.GoodsVO;
import vo.SignalVO;

public interface GL_signal_BLservice {
	/*check whether some goods is exist and the signal is modifiable*/
	boolean check(GoodsVO goods) throws Exception;
	boolean setSignal(GoodsVO goods, int amount) throws Exception;//Hashmap<String(id), int> signalMap
	boolean getSignal(GoodsVO goods);
	SignalVO sendSignal();
	
	ResultMesPO update();
}
