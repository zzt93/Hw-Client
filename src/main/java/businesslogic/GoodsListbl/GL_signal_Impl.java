package businesslogic.GoodsListbl;

import java.util.HashMap;

import po.GoodsListPO;
import po.GoodsModelPO;
import po.ResultMesPO;
import vo.GoodsVO;
import vo.SignalVO;
import businesslogicservice.GoodsListblservice.GL_signal_BLservice;

public class GL_signal_Impl implements GL_signal_BLservice {
	
	GoodsListPO goodsListPO ;
	public GL_signal_Impl(GoodsListPO goodsListPO) {
		this.goodsListPO = goodsListPO;
	}

	public boolean check_signal(GoodsVO goods) throws Exception {
		System.err.println("this method shouldn't be invoked");
		System.exit(0);
		return false;
	}

	public boolean checkSignalModifiable(GoodsVO goodsVO) throws Exception {
		return true;
	}

	public boolean setSignal(GoodsVO goods) throws Exception {
		HashMap<String, GoodsModelPO> goodsModels = goodsListPO.getGoodsModels();
		GoodsModelPO temp = goodsModels.get(goods.id);
		if (goods.amount > 0) {//may be more logic here
			temp.setSignal(goods.amount);
			return true;
		}
		return false;
	}

	public int getSignal(GoodsVO goods) throws Exception {
		HashMap<String, GoodsModelPO> goodsModels = goodsListPO.getGoodsModels();
		GoodsModelPO temp = goodsModels.get(goods.id);
		
		return temp.getSignal();
	}

	public SignalVO sendSignal(int amount, int signal, String id) throws Exception {
		SignalVO signalVO = new SignalVO(amount, signal, id);
		return signalVO;
	}

	public boolean update_when_sale(GoodsVO goodsVO) throws Exception {
		int signal = getSignal(goodsVO);
		int amount = getAmount(goodsVO);
		if (signal < amount) {
			sendSignal(amount, signal, goodsVO.id);
			return true;
		}
		return false;
	}

	private int getAmount(GoodsVO goodsVO){
		HashMap<String, GoodsModelPO> temp = goodsListPO.getGoodsModels();
		return temp.get(goodsVO.id).getAmount();
	}
}
