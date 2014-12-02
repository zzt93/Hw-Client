package vo;

import po.GoodsReceiptPO;
import po.ReceiptPO;

import java.io.Serializable;
import java.util.ArrayList;

public class GoodsReceiptVO extends ReceiptPO implements Serializable {
	ArrayList<GoodsVO> goodsPOs;
	double sumOfGifts;
	
	public GoodsReceiptVO(GoodsReceiptPO goodsReceiptPO) {
		// TODO Auto-generated constructor stub
	}
	public GoodsReceiptVO(ArrayList<GoodsVO> goodsVOs, String date, String user) {
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<GoodsVO> getGoodsPOs() {
		return goodsPOs;
	}
	public void setGoodsPOs(ArrayList<GoodsVO> goodsPOs) {
		this.goodsPOs = goodsPOs;
	}
	public double getSumOfGifts() {
		return sumOfGifts;
	}
	
}
