package dzh.blservice.Approve;

import java.util.ArrayList;

import dzh.blservice.Receipt;

public interface ListInterface {
	ArrayList<Receipt> showList();
	ArrayList<Receipt> refresh();
	boolean passList(ArrayList<Receipt> array);
	
}
