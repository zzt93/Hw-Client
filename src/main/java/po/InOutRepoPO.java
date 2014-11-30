package po;

import java.math.BigDecimal;
import java.util.Date;

public class InOutRepoPO {
	String produce_date;
	String[] date = new String[2];
	BigDecimal sumOfIn;
	BigDecimal sumOfOut;
	int sumOfNum;
	
	public InOutRepoPO(BigDecimal in, BigDecimal out, int num, String s, String e) {
		produce_date = new Date().toString();
		sumOfOut = out;
		sumOfIn = in;
		sumOfNum = num;
		date[0] = s;
		date[1] = e;
	}
	
	public String getProduce_date() {
		return produce_date;
	}

	public BigDecimal getSumOfIn() {
		return sumOfIn;
	}

	public BigDecimal getSumOfOut() {
		return sumOfOut;
	}

	public String getDate() {
		return produce_date;
	}
	
	public int getSumOfNum() {
		return sumOfNum;
	}
	
}
