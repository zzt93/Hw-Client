package businesslogic.Approvebl;

public class Approve_Driver {

	public void drive(Approve_Mock stub){
		stub.confirm();
		stub.passList(null);
		stub.refresh();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Approve_Driver().drive(new Approve_Mock());;
	}

}
