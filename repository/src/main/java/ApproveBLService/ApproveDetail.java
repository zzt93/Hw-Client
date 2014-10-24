package ApproveBLService;

import PO.ReceiptPO;

public interface ApproveDetail {
	ReceiptPO show(int serial);
	void confirm();
	
}