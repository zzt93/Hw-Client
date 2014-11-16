package vo;

import java.util.HashMap;

public class SignalVO {
	
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
