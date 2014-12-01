package businesslogic.BankManagebl;

//import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import vo.BankVO;

import static org.junit.Assert.assertTrue;

public class BankControllerTest {
	BankController controller=new BankController();
	BankVO vo=new BankVO();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testAdd() {
		try{
			controller.add(vo);
			assertTrue(false);
		}catch(Exception e){
			System.out.println(e.getMessage());
			assertTrue(true);
		}
	}

	@Test
	public void testDelete() {
		try{
			controller.delete(vo);
		}catch(Exception e){
			System.out.println(e.getMessage());
			assertTrue(false);
		}
	}

	@Test
	public void testModify() {
		try{
			controller.modify(vo);
		}catch(Exception e){
			System.out.println(e.getMessage());
			assertTrue(false);
		}
	}

	@Test
	public void testSearch() {
		try{
			BankVO[] list=controller.search("测试");
			if(list[0].equals(new BankVO())){
				System.out.println("lala");
				assertTrue(true);
			}else
			assertTrue(false);
		}catch(Exception e){
			System.out.println(e.getMessage());
			assertTrue(false);
		}

	}

}
