package po;

import java.util.ArrayList;

import vo.GoodsReceiptVO;
/**
 * Edited by dzh,add extension,11.12
 *
 */
public class GoodsReceiptPO extends ReceiptPO{
	ArrayList<GoodsPO> goodsPOs;
	double sumOfGifts;
	
	public GoodsReceiptPO(GoodsReceiptVO goodsVOs) {
		// TODO Auto-generated constructor stub
	}
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
