package po;

import vo.GoodsReceiptVO;
import vo.GoodsVO;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Edited by dzh,add extension,11.12
 *
 */
public class GoodsReceiptPO extends ReceiptPO implements Serializable {
	private static final long serialVersionUID = 1L;
	ArrayList<GoodsVO> goodsVOs;
	double sumOfGifts;
	String user;
	public GoodsReceiptPO(GoodsReceiptVO goodsReceiptVO) {
		user = goodsReceiptVO.getUser();
		for (GoodsVO goodsVO : goodsReceiptVO.getGoodsVOs()) {
			goodsVOs.add(goodsVO);
		}
		sumOfGifts = goodsReceiptVO.getSumOfGifts();

		number = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	}
	
	public ArrayList<GoodsVO> getGoods() {
		return goodsVOs;
	}
	public String getUser() {
		return user;
	}

	public void setGoodsPOs(ArrayList<GoodsVO> goodsPOs) {
		this.goodsVOs = goodsPOs;
	}
	public double getSumOfGifts() {
		return sumOfGifts;
	}
	public void setSumOfGifts(double sumOfGifts) {
		this.sumOfGifts = sumOfGifts;
	}
	public String getId(){
		return number;
	}

	
}
