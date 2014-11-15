package businesslogic.GoodsListbl;

import static org.junit.Assert.*;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.junit.Before;
import org.junit.Test;

public class GL_test {

	GL_controller gl;
	@Before
	public void setUp() throws Exception {
		gl = new GL_controller();
	}

	@Test
	public <T> void test() {
		assertThat("test ", 0, new BaseMatcher<Integer>() {

			public boolean matches(Object arg0) {
				// TODO Auto-generated method stub
				return false;
			}

			public void describeTo(Description arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}

}
