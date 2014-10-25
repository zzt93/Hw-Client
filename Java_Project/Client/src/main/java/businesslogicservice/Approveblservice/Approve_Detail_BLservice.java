package ApproveBLService;

import PO.ReceiptPO;

public interface Approve_Detail_BLservice {
	ReceiptPO show(int serial);
	void confirm();
	
}