package po;

import java.io.Serializable;

/**
 * 
 * @author Mebleyev.G.Longinus
 *
 */

public class ReceiptPO implements Serializable {
	private static final long serialVersionUID = 1L;
	public ReceiptState state=ReceiptState.disapprove;
	public String receipt_id;
	public ReceiptType type;
	public String time;

	public ReceiptPO() {
	}

	public ReceiptPO(ReceiptType type) {
		this.type = type;
	}
	
}
