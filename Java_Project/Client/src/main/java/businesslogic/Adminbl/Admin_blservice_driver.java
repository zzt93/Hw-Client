package businesslogic.Adminbl;

import java.rmi.RemoteException;

import po.UserPO;

public class Admin_blservice_driver {
	
	public void drive(Admin_blservice_stub stub){
		
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
		new Admin_blservice_driver().drive(new Admin_blservice_stub());
	}

}
