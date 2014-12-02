package po;

import java.io.Serializable;

/**
 * 
 * @author Mebleyev.G.Longinus
 *
 */

public class ReceiptPO implements Serializable {
	public int id;
	public ReceiptState statement=ReceiptState.disapprove;
	public String number;
	public ReceiptType type;
	public String time;

	public ReceiptPO() {
	}

	public ReceiptPO(ReceiptType type) {
		this.type = type;
	}
}
