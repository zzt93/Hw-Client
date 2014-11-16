package businesslogic.Approvebl;
import static org.junit.Assert.*;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.junit.Before;
import org.junit.Test;
public class Approve_test {
	Approve_List al;
	Approve_Detail ad;
	
	@Before
	public void setUp() throws Exception{
		al = new Approve_List();
		
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
