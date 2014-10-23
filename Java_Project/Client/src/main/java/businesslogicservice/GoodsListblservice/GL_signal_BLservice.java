package businesslogicservice.GoodsListblservice;

import vo.Goods;

public interface GL_signal_BLservice {
	/*check whether some goods is exist and the signal is modifiable*/
	boolean check(Goods goods);
	boolean setSignal(Goods goods, int amount);//Hashmap<String(id), int> signalMap
}
