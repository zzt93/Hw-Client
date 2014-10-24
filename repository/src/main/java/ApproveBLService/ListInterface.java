package ApproveBLService;

import java.util.ArrayList;

import PO.ReceiptPO;

public interface ListInterface {
	ArrayList<ReceiptPO> showList();
	ArrayList<ReceiptPO> refresh();
	boolean passList(ArrayList<ReceiptPO> array);
	
}
