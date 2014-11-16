package po;

import java.util.ArrayList;

public class GoodsReceiptPO {
	ArrayList<GoodsPO> goodsPOs;
	double sumOfGifts;
	
	public ArrayList<GoodsPO> getGoodsPOs() {
		return goodsPOs;
	}
	public void setGoodsPOs(ArrayList<GoodsPO> goodsPOs) {
		this.goodsPOs = goodsPOs;
	}
	public double getSumOfGifts() {
		return sumOfGifts;
	}
	public void setSumOfGifts(double sumOfGifts) {
		this.sumOfGifts = sumOfGifts;
	}
}
