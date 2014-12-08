package businesslogic.GoodsListbl;

import org.junit.Before;
import org.junit.Test;
import vo.GoodsModelVO;

import static org.junit.Assert.assertTrue;

public class GL_test {

	GL_controller gl;
	@Before
	public void setUp() throws Exception {
		gl = new GL_controller();
	}

	@Test
	public <T> void test() {
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
			assert(false);
		}
/*		assertThat("test ", 0, new BaseMatcher<Integer>() {

			public boolean matches(Object arg0) {
				// TODO Auto-generated method stub
				return false;
			}

			public void describeTo(Description arg0) {
				// TODO Auto-generated method stub
				
			}
		}); */
	}

}
