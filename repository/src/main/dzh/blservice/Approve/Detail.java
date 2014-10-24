package dzh.blservice.Approve;

import dzh.blservice.Receipt;

public interface Detail {
	Receipt show(int serial);
	void confirm();
	
}