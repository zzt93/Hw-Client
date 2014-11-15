package businesslogic.BankManagebl;

//import static org.junit.Assert.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import po.BankPO;
import vo.BankVO;

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
		}catch(Exception e){
			System.out.println(e.getMessage());
			assertTrue(false);
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

	@SuppressWarnings("deprecation")
	@Ignore
	public void testSearch() {
		try{
			BankVO[] list=new BankVO[1];
			BankVO[] list2=new BankVO[1];
			list[0]=new BankVO(new BankPO());
			list2[0]=new BankVO();
			BankVO a=new BankVO();
			BankVO b=new BankVO();
			int[] array1={1,2,3};
	        int[] array2={1,2,3};
	        System.out.println(a.equals(b));
			assertEquals(b,a);
		}catch(Exception e){
			System.out.println(e.getMessage());
			assertTrue(false);
		}

	}

}
