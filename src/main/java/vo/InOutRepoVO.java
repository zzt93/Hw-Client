package vo;

import java.math.BigDecimal;
import java.util.Date;

public class InOutRepoVO {
	String produce_date;
	String[] date = new String[2];
	BigDecimal sumOfIn;
	BigDecimal sumOfOut;
	int sumOfIn_num;
	int sumOfOut_num;
	
	public InOutRepoVO(BigDecimal in, BigDecimal out, int inn, int outn, String s, String e) {
		produce_date = new Date().toString();
		sumOfOut = out;
		sumOfIn = in;
		sumOfIn_num = inn;
		sumOfOut_num = outn;
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

	public int getSumOfIn_num() {
		return sumOfIn_num;
	}

	public int getSumOfOut_num() {
		return sumOfOut_num;
	}
	

	
}
