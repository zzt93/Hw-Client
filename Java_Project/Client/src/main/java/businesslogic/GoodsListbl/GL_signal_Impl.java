package businesslogic.GoodsListbl;

import po.GoodsListPO;
import po.ResultMesPO;
import vo.GoodsVO;
import vo.SignalVO;
import businesslogicservice.GoodsListblservice.GL_signal_BLservice;

public class GL_signal_Impl implements GL_signal_BLservice {
	
	GoodsListPO goodsListPO ;
	public GL_signal_Impl(GoodsListPO goodsListPO) {
		this.goodsListPO = goodsListPO;
	}

	public boolean check(GoodsVO goods) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean checkSignalModifiable(GoodsVO goodsVO) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean setSignal(GoodsVO goods, int amount) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean getSignal(GoodsVO goods) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	public SignalVO sendSignal() {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMesPO update() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
