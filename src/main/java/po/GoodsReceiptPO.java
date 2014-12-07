package po;

import vo.GoodsReceiptVO;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * Edited by dzh,add extension,11.12
 *
 */
public class GoodsReceiptPO extends ReceiptPO implements Serializable {
	private static final long serialVersionUID = 1L;
	ArrayList<GoodsPO> goodsPOs;
	double sumOfGifts;
	GoodsReceiptVO goodsReceiptVO;
	public GoodsReceiptPO(GoodsReceiptVO goodsReceiptVO) {
		this.goodsReceiptVO = goodsReceiptVO;
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
	public String getId(){
		return goodsReceiptVO.getReceipt_Id();
	}

	public GoodsReceiptVO getGoodsReceiptVO() {
		return goodsReceiptVO;
	}
}
