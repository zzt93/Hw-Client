package vo;

import java.util.ArrayList;

import po.ReceiptPO;

public class GoodsReceiptVO extends ReceiptPO{
	ArrayList<GoodsVO> goodsPOs;
	double sumOfGifts;
	
	public ArrayList<GoodsVO> getGoodsPOs() {
		return goodsPOs;
	}
	public void setGoodsPOs(ArrayList<GoodsVO> goodsPOs) {
		this.goodsPOs = goodsPOs;
	}
	public double getSumOfGifts() {
		return sumOfGifts;
	}
	public void setSumOfGifts(double sumOfGifts) {
		this.sumOfGifts = sumOfGifts;
	}
}
