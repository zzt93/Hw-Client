package businesslogic.Logbl;

public class Logbl_driver {
	public void driver(Logbl_stub log){
		try {
			String[] record=log.check();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
