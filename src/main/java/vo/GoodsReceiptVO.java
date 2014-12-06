package vo;

import po.GoodsReceiptPO;
import po.ReceiptPO;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

public class GoodsReceiptVO extends ReceiptPO implements Serializable {
	static long count = 0;
	
	String id;
	String date;
	String user;
	
	Vector<GoodsVO> goodsVOs;
	double sumOfGifts;
	private static final long serialVersionUID = 1L;

	public GoodsReceiptVO(GoodsReceiptPO goodsReceiptPO) {
		//TODO
	}
	public GoodsReceiptVO(Vector<GoodsVO> goodsVOs, String user) {
		// TODO Auto-generated constructor stub
		id = ""+count++;
		date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		this.goodsVOs = goodsVOs;
		this.user = user; 
	}
	
	public String getDate() {
		return date;
	}
	public Vector<GoodsVO> getGoodsVOs() {
		return goodsVOs;
	}
	public void setGoodsPOs(Vector<GoodsVO> goodsPOs) {
		this.goodsVOs = goodsPOs;
	}
	public double getSumOfGifts() {
		return sumOfGifts;
	}
	public String getUser() {
		return user;
	}
	public String getId() {
		return id;
	}
}
