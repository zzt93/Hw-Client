package businesslogic.Logbl;

import businesslogicservice.Logblservice.Logblservice;

public class Logbl_stub implements Logblservice {

	public String[] check() throws Exception {
		String[] a=new String[2];
		a[0]="这是一条日志记录";
		a[1]="这是一条日志记录";
		return a;
	}

}
