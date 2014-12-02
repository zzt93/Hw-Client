package po;

import vo.GoodsReceiptVO;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * Edited by dzh,add extension,11.12
 *
 */
public class GoodsReceiptPO extends ReceiptPO implements Serializable {
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
