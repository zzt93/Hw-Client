package businesslogic.GoodsTypebl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import vo.TreeNodeVO;

public class GT_controllerTest {

	GT_controller gt ;
	@Before
	public void setUp() throws Exception {
		gt = new GT_controller();
	}

	@Test
	public void test() {
		try {
			assertTrue(gt.add(new TreeNodeVO(), "a"));
			assertTrue(gt.delete(new TreeNodeVO()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			assert(false);
		}
		
	}

}