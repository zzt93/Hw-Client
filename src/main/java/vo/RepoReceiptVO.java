package vo;

import po.ReceiptPO;
import po.ReceiptType;
import po.RepoReceiptPO;

import java.io.Serializable;

public class RepoReceiptVO extends ReceiptPO implements Serializable {
	private static final long serialVersionUID = 1L;
	int actualNum;
	int statisticNum;
	ReceiptType type;
	String date;
	String goods_id;
	String receipt_id;
	public RepoReceiptVO(RepoReceiptPO repoReceiptPO) {
		this.actualNum = repoReceiptPO.getaNum();
		this.statisticNum = repoReceiptPO.getcNum();
		this.type = ReceiptType.REPORECEIPT;
		this.date = repoReceiptPO.getDate();
		this.goods_id = repoReceiptPO.getGoods_id();
		this.receipt_id = repoReceiptPO.getReceipt_id();
	}
}
