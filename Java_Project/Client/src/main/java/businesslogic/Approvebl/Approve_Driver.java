package businesslogic.Approvebl;

import java.rmi.RemoteException;

public class Approve_Driver {

	public void drive(Approve_Stub stub){
		stub.confirm();
		stub.passList(null);
		stub.refresh();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Approve_Driver().drive(new Approve_Stub());;
	}

}
