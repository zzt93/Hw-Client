package vo;

import java.io.Serializable;
import java.util.HashMap;

import po.ReceiptPO;
import po.ReceiptType;

public class SignalVO extends ReceiptPO implements Serializable {
	private static final long serialVersionUID = 1L;
	public SignalVO(int a, int s, String string) {
		type = ReceiptType.SIGNAL;
		amount = a;
		sAmount = s;
		signal = string;
	}
	String signal;
	int amount;
	int sAmount;
	
	HashMap<String, Integer> signalMap;

	@Override
	public String toString() {
		return signal +" "+ amount +" "+ sAmount;
	} 
}
