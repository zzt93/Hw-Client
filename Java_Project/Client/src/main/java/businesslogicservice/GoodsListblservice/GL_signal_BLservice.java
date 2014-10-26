package businesslogicservice.GoodsListblservice;

import vo.GoodsVO;

public interface GL_signal_BLservice {
	/*check whether some goods is exist and the signal is modifiable*/
	boolean check(GoodsVO goods);
	boolean setSignal(GoodsVO goods, int amount);//Hashmap<String(id), int> signalMap
}
