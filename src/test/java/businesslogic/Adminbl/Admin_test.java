package businesslogic.Adminbl;

import static org.junit.Assert.assertThat;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.junit.Before;
import org.junit.Test;

public class Admin_test {
	Admin_mock am;
	@Before
	public void setUp() throws Exception {
		am = new Admin_mock();
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
