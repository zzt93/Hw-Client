package businesslogic.GoodsTypebl;

import org.junit.Before;
import org.junit.Test;
import po.TreeNodePO;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class GT_controllerTest {

	GT_controller gt ;
	TreeNodePO son = new TreeNodePO("light");
	@Before
	public void setUp() throws Exception {
		gt = new GT_controller();
	}

	@Test
	public void test() {
		try {
			// add the son
			assertTrue(gt.add(son));

			TreeNodePO son11 = new TreeNodePO(son);
			TreeNodePO son12 = new TreeNodePO(son, "test1");
			assertTrue(gt.add(son11));
			assertTrue(gt.add(son12));
			/*
				try to delete it
			*  result should be false
			*  */
			assertTrue(gt.delete(son));

			// try update one node's type
			TreeNodePO son11_update = new TreeNodePO(son11.getFa(), son11.getType());
			son11_update.setType("test0");
			assertTrue(gt.update(son11_update));


		} catch (Exception e) {
			e.printStackTrace();
			assert(false);
		}
		
	}

}
