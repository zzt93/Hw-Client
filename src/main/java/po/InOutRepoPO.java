package po;

import java.math.BigDecimal;
import java.util.Date;

public class InOutRepoPO {
	String date;
	BigDecimal sumOfMoney;
	int sumOfNum;
	
	public InOutRepoPO(BigDecimal mon, int num) {
		date = new Date().toString();
		sumOfMoney = mon;
		sumOfNum = num;
	}
	
	public String getDate() {
		return date;
	}
	
	public BigDecimal getSumOfMoney() {
		return sumOfMoney;
	}
	
	public int getSumOfNum() {
		return sumOfNum;
	}
	
}
