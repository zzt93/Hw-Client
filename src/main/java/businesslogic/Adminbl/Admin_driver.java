package businesslogic.Adminbl;

import po.UserPO;

import java.rmi.RemoteException;

public class Admin_driver {
	
	public void drive(Adminbl stub){
		
		try {
			stub.confirm(null);
			stub.delete(new UserPO(0, null, null, null));
			stub.newUser();
			stub.show();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Admin_driver().drive(new Adminbl());
	}

}
