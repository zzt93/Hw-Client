package blservice.Approve;

import blservice.Receipt;

public interface Detail {
	Receipt show(int serial);
	void confirm();
	
}