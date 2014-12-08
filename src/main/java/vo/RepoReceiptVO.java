package vo;

import po.ReceiptPO;
import po.ReceiptType;
import po.RepoReceiptPO;

import java.io.Serializable;

public class RepoReceiptVO extends ReceiptPO implements Serializable {
	private static final long serialVersionUID = 1L;
	public int actualNum;
	public int statisticNum;
	public String goods_id;
	public RepoReceiptVO(RepoReceiptPO repoReceiptPO) {
		this.actualNum = repoReceiptPO.getaNum();
		this.statisticNum = repoReceiptPO.getcNum();
		type = ReceiptType.REPORECEIPT;
		time = repoReceiptPO.getDate();
		this.goods_id = repoReceiptPO.getGoods_id();
		this.receipt_id = repoReceiptPO.getReceipt_id();
	}
	public RepoReceiptVO() {
	}
}
