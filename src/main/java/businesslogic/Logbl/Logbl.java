package businesslogic.Logbl;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import util.RMIUtility;
import dataservice.Logdataservice.Logdataservice;
import businesslogicservice.Logblservice.Logblservice;

public class Logbl implements Logblservice {
	private static Logdataservice impl;
	public Logbl() throws RemoteException,NotBoundException{
		if (impl == null)
            impl = (Logdataservice) RMIUtility.getImpl("Log");
	}
	public String[] check() throws Exception {
		String[] a=new String[2];
		a[0]="这是一条日志记录";
		a[1]="这是一条日志记录";
		return a;
	}

	
	@SuppressWarnings("unchecked")
	public ArrayList<String> open(){
		try {
			if(impl.finds().getErrMessage()==null){
				return (ArrayList<String>)impl.finds().getObj();
			}else{
				ArrayList<String> str = new ArrayList<String>();
				str.add(impl.finds().getErrMessage());
				return str;
			}

		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}return null;
		
	}
	public void close(){
		
	}
	public String record(String str){
		return str;
	}
}
