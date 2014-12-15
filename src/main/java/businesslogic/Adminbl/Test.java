package businesslogic.Adminbl;

import java.rmi.RemoteException;

import po.UserPO;

public class Test {
	public static void main(String[] args){
		UserPO po = new UserPO(1111,"admin","123456","manager");
		try {
			Adminbl abl= new Adminbl();
			abl.show();
			boolean success = abl.confirm(po);
			System.out.println(success);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
}
