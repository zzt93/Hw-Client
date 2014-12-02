package vo;

import java.io.Serializable;
import java.util.HashMap;

public class SignalVO implements Serializable {
	
	public SignalVO(int a, int s, String string) {
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
		return signal + amount + sAmount;
	} 
}
